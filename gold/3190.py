import copy

N=int(input())
K=int(input())
apples=[list((map(int,input().split(' ')))) for i in range(K)]
L=int(input())
commands=["X"]*10001
for i in range(L):
    time,op=input().split(' ')
    commands[int(time)]=op

board=[[[".",(0,0)] for _ in range(N)] for i in range(N)]
# print(board)
board[0][0][0]="B"; board[0][0][1]=(0,1)
startR=0;startC=0;length=1;tailR=0;tailC=0
for r,c in apples:
    board[r-1][c-1][0] ="A"

def leftdir(dir):
    if dir==(0,1):
        return -1,0
    if dir==(1,0):
        return 0,1
    if dir==(0,-1):
        return 1,0
    if dir==(-1,0):
        return 0,-1
def rightdir(dir):
    if dir==(0,1):
        return 1,0
    if dir==(1,0):
        return 0,-1
    if dir==(0,-1):
        return -1,0
    if dir==(-1,0):
        return 0,1

def move(t,op,startR,startC,tailR,tailC,dirR,dirC,length):
    N=len(board)
    R=startR+dirR; C=startC+dirC
    if 0<=R<N and 0<=C<N and board[R][C][0]!="B":
        if board[R][C][0]=="A":
            board[R][C][0]="B"; board[R][C][1]=(dirR,dirC)
            board[startR][startC][1]=(dirR,dirC)
        else:
            board[R][C][0]="B"
            # print(tmp,tailR,tailC)
            board[tailR][tailC][0]=".";board[startR][startC][1]=(dirR,dirC)
            tmp=board[tailR][tailC][1]
            tailR+=tmp[0];tailC+=tmp[1]
    else:
        print(t)
        exit(0)
    if op == "L":
        dirR,dirC=leftdir((dirR,dirC))
    if op == "D":
        dirR,dirC=rightdir((dirR,dirC))
    return R,C,tailR,tailC,dirR,dirC
    

dirR=0;dirC=1
for t in range(1,10001):
    startR,startC,tailR,tailC,dirR,dirC=move(t,commands[t],startR,startC,tailR,tailC,dirR,dirC,length)
    # print(t,commands[t],dirR,dirC,tailR,tailC)
    # print(*board,sep='\n')
