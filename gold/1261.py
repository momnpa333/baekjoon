import sys
from collections import deque
input=sys.stdin.readline

M,N=map(int,input().split())

board=[list(map(int,map(str,input().rstrip()))) for _ in range(N)]
check=[[float('inf')]*M for _ in range(N)]

dq=deque([])
dq.append((0,0,0))
check[0][0]=0
while dq:
    for _ in range(len(dq)):
        r,c,cnt=dq.popleft()
        for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
            R=r+addr; C=c+addc
            if 0<=R<N and 0<=C<M:
                if board[R][C]==1 and cnt+1<check[R][C]:
                    dq.append((R,C,cnt+1)); check[R][C]=cnt+1
                elif board[R][C]==0 and cnt<check[R][C]:
                    dq.append((R,C,cnt)); check[R][C]=cnt

print(check[N-1][M-1])

