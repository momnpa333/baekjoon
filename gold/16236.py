import sys
from collections import deque 
input=sys.stdin.readline

N=int(input())
lev=[2,0]
sea=[list(map(int,input().split())) for _ in range(N)]
r=0;c=0
#아기상어 위치찾기
for i in range(N):
    for j in range(N):
        if sea[i][j]==9:
            r,c=i,j
dc=[0,-1,1,0]
dr=[-1,0,0,1]
answer=0
def bfs(r,c):
    flag=0
    global answer
    global N
    choice=[]
    Time=0
    check=[[0]*N for i in range(N)]
    check[r][c]=1
    dq=deque()
    dq.append([r,c])
    while dq:
        T=len(dq)
        Time+=1
        while T>0:
            T-=1
            tmp=dq.popleft()
            for i in range(4):
                R=tmp[0]+dr[i]
                C=tmp[1]+dc[i]
                if 0<=R<N and 0<=C<N:
                    if 0<sea[R][C]<lev[0]:
                        flag=1
                        choice.append([R,C])
                    elif check[R][C]==0 and (sea[R][C]==lev[0] or sea[R][C]==0):
                        check[R][C]=1
                        dq.append([R,C])
        if flag==1:
            choice.sort(key=lambda x:(x[0],x[1]))
            print(choice)
            R=choice[0][0];C=choice[0][1]
            sea[R][C]=0
            lev[1]+=1
            if lev[1]==lev[0]:
                lev[0]+=1
                lev[1]=0
            answer+=Time
            return bfs(choice[0][0],choice[0][1])
sea[r][c]=0
bfs(r,c)
print(answer)

