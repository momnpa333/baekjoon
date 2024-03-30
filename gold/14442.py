from collections import deque
import heapq,copy

N,M,K=map(int,input().split(' '))
maze=[list(map(int,map(str,input()))) for i in range(N)]

dq=deque([])
q=[]
check=set()
cnt=0
depth=1
# dq.append((depth,0,0,cnt,check))
dq.append((depth,0,0,cnt))
check=[[float('inf')]*M for i in range(N)]
check[0][0]=0
answer=[]
if N==1 and M==1:
    print(1)
    exit(0)
while dq:
    depth,r,c,cnt=dq.popleft()
    for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
        R=r+addr; C=c+addc
        if 0<=R<N and 0<=C<M:
            if R==N-1 and C==M-1:
                print(depth+1)
                exit()
                
            if maze[R][C]==0 and cnt<check[R][C]:
                check[R][C]=cnt
                dq.append((depth+1,R,C,cnt))
            if maze[R][C]==1 and cnt<K and cnt+1<check[R][C]:
                check[R][C]=cnt+1
                dq.append((depth+1,R,C,cnt+1))
print(-1)


