from collections import deque

N=int(input())
board=[list(map(int,input().split(" "))) for _ in range(N)]
maxcache=[[0,0,0] for _ in range(N)]
mincache=[[float('inf'),float('inf'),float('inf')] for _ in range(N)]

dq=deque([])

dq.append((0,0,board[0][0]))
dq.append((0,1,board[0][1]))
dq.append((0,2,board[0][2]))

maxcache[0][1]=board[0][1]
maxcache[0][2]=board[0][2]
maxcache[0][0]=board[0][0]

mincache[0][1]=board[0][1]
mincache[0][2]=board[0][2]
mincache[0][0]=board[0][0]


answer=[]

while dq:
    for _ in range(len(dq)):
        row,curposi,score=dq.popleft()
        row+=1
        for addposi in (-1,0,1):
            posi=curposi+addposi
            if row==len(board):
                answer.append(score)
            if 0<=posi<3 and row<len(board):
                maxcache[row][posi]=max(score+board[row][posi],maxcache[row][posi])
    if row==len(board)-1:
        break
    for i in (0,1,2):
        dq.append((row,i,maxcache[row][i]))

dq=deque([])

dq.append((0,0,board[0][0]))
dq.append((0,1,board[0][1]))
dq.append((0,2,board[0][2]))

while dq:
    print(dq)
    for _ in range(len(dq)):
        row,curposi,score=dq.popleft()
        row+=1
        for addposi in (-1,0,1):
            posi=curposi+addposi
            if row==len(board):
                answer.append(score)
            if 0<=posi<3 and row<len(board):
                mincache[row][posi]=min(score+board[row][posi],mincache[row][posi])
    if row==len(board)-1:
        break
    for i in (0,1,2):
        dq.append((row,i,mincache[row][i]))
print(max(maxcache[N-1]),min(mincache[N-1]))

