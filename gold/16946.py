import sys
from collections import deque
input=sys.stdin.readline

N,M=map(int,input().split())

dr=[0,1,0,-1]
dc=[1,0,-1,0]
maze=[list(map(int,input().strip()))for _ in range(N)]
trace=[[0]*M for _ in range(N)]
answer=[[0]*M for _ in range(N)]
class MyClass:
    value=1

def bfs(r,c):
    check=[[0]*M for _ in range(N)]
    dq=deque([])
    dq.append([r,c])
    cnt=MyClass()
    trace[r][c]=cnt
    check[r][c]=1
    while dq:
        T=len(dq)
        while T>0:
            T-=1
            tmp=dq.popleft()
            r1=tmp[0]
            c1=tmp[1]
            for i in range(4):
                R=dr[i]+r1
                C=dc[i]+c1
                if 0<=R<N and 0<=C<M and check[R][C]==0 and maze[R][C]==0:
                    check[R][C]=1
                    cnt.value+=1
                    trace[R][C]=cnt
                    dq.append([R,C])
                    
    return cnt
for i in range(N):
    for j in range(M):
        if maze[i][j]==0 and trace[i][j]==0:
            bfs(i,j)

tmp=[]
sum=0
for i in range(N):
    for j in range(M):
        if maze[i][j]==1:
            for k in range(4):
                r=i+dr[k]
                c=j+dc[k]
                if 0<=r<N and 0<=c<M and type(trace[r][c])==MyClass and trace[r][c] not in tmp:
                    tmp.append(trace[r][c])
            for l in tmp:
                sum+=l.value
            answer[i][j]=(sum+1)%10
            sum=0
            tmp=[]
                
for i in range(N):
    for j in range(M):
        print(answer[i][j],end="")
    print()

                

