import sys
input=sys.stdin.readline

N,M=map(int,input().split())

startR,startC,startDir=map(int,input().split())
DirAry=[(-1,0),(0,1),(1,0),(0,-1)]
board=[]
solve=0
for i in range(N):
    board.append(list(map(int,input().split())))

def isdirty(r,c):
    if 0<=r<N and 0<=c<M and board[r][c]==0:
            if board[r][c]==0:
                return True
    return False

def cleanRoom(r,c):
    global solve
    #현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
    if board[r][c]==0:
        board[r][c]="X"
        solve+=1

r,c,dir=startR,startC,startDir
while True:
    #현재 위치를 청소한다.
    cleanRoom(r,c)

    dirc=dir
    dirt=dir
    isExist=False
    #현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인한다.
    for i in range(4):
        dirc=(dir+i)%4
        nextR=r+DirAry[dirc][0]
        nextC=c+DirAry[dirc][1]
        if isdirty(nextR,nextC):
            isExist=True
            break
    #현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
    if not isExist:
        #후진
        nextR=r-DirAry[dir][0]
        nextC=c-DirAry[dir][1]
        r=nextR
        c=nextC
        #후진할 수 없는 경우 작동을 멈춘다.
        if not 0<=nextR<N or not 0<=nextC<M or board[nextR][nextC]==1:
            print(solve)
            exit(0)
    else:    
        for i in (1,2,3,4):
            dir=(dirt-i)%4
            nextR=r+DirAry[dir][0]
            nextC=c+DirAry[dir][1]
            if 0<=nextR<N and 0<=nextC<M and board[nextR][nextC]==0:
                r=nextR
                c=nextC
                break

