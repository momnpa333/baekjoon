from collections import deque

N=int(input())
board=[list(map(int,input().split())) for _ in range(N)]
node=[[0]*N for _ in range(N)]; length=[[float('inf')]*N for _ in range(N)]
startSet=set()
answer=float('inf')

def make_node(r,c,cnt):
    dq=deque([])
    dq.append((r,c))
    node[r][c]=cnt

    while dq:
        for _ in range(len(dq)):
            curr,curc=dq.popleft()
            for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
                R=curr+addr; C=curc+addc
                if 0<=R<N and 0<=C<N and board[R][C]==1 and node[R][C]==0:
                    node[R][C]=cnt; dq.append((R,C))

def path(r,c,s):
    dq=deque([])
    dq.append((r,c,0))
    global answer

    while dq:
        for _ in range(len(dq)):
            curr,curc,v=dq.popleft()
            for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
                R=curr+addr; C=curc+addc
                if 0<=R<N and 0<=C<N and v+1<length[R][C]:
                    if node[R][C]==0:
                        length[R][C]=v+1
                        dq.append((R,C,v+1))
                    elif node[R][C]!=s:
                        answer=min(answer,v)
                    
cnt=0
for r in range(N):
    for c in range(N):
        if board[r][c]==1 and node[r][c]==0:
            cnt+=1
            make_node(r,c,cnt)
        if board[r][c]==1:
            for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
                R=r+addr; C=c+addc
                if 0<=R<N and 0<=C<N and board[R][C]==0:
                    startSet.add((r,c))
                    break
          
for r,c in startSet:
    path(r,c,node[r][c])

print(answer)