import sys
from collections import deque

input=sys.stdin.readline

N,M=map(int,input().split())

board=[list(map(int,input().split())) for _ in range(N)]
check=[[(0,-1,-1) for _ in range(M)] for _ in range(N)]
dq=deque([])

def make_cnt(r,c):
    dq=deque([])
    dq.append((r,c))
    hist=set()
    hist.add((r,c))
    while dq:
        for _ in range(len(dq)):
            curr,curc=dq.popleft()
            for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
                R=addr+curr; C=addc+curc
                if 0<=R<N and 0<=C<M and board[R][C]==1 and (R,C) not in hist:
                    hist.add((R,C))
                    dq.append((R,C))
    return hist


# for 

for r in range(N):
    for c in range(M):
        if board[r][c]==1 and check[r][c][0]==0:
            block_set=make_cnt(r,c)
            for b_r,b_c in block_set:
                check[b_r][b_c]=(len(block_set),r,c)
answer=0
for r in range(N):
    for c in range(M):
        if board[r][c]==0:
            candi=set()
            for addr,addc, in ((0,1),(1,0),(0,-1),(-1,0)):
                R=addr+r; C=addc+c
                if 0<=R<N and 0<=C<M:
                    candi.add(check[R][C])
            block_size=0
            for block,_,_ in candi:
                block_size+=block
            answer=max(answer,block_size+1)
print(answer)

