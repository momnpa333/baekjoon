import sys, copy
from collections import deque
input=sys.stdin.readline

N=int(input())
homes=[]
for i in range(N):
    homes.append(list(map(int,input().strip())))
copyhomes=[]
for i in range(N):
    copyhomes.append([0]*N)
dr=[0,1,0,-1]
dc=[1,0,-1,0]
answer=[]


def bfs(r,c):
    dq=deque([])
    dq.append((r,c))
    copyhomes[r][c]=1
    cnt=1
    while dq:
        T=len(dq)
        while T>0:
            T-=1
            tr,tc=dq.popleft()
            for i in range(4):
                r=dr[i]+tr ; c=dc[i]+tc
                if 0<=r<N and 0<=c<N and homes[r][c]==1 and copyhomes[r][c]!=1:
                    dq.append((r,c))
                    copyhomes[r][c]=1
                    cnt+=1
    return cnt

for i in range(N):
    for j in range(N):
        if homes[i][j]==1 and copyhomes[i][j]==0:
            answer.append(bfs(i,j))
answer=sorted(answer)
print(len(answer))
print(*answer)
            

