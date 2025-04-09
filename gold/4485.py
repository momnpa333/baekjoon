# 2:34-> 2:49
import sys,heapq


T=0
while True:
    T+=1
    N=int(input())
    if N==0:
        break

    board=[list(map(int,input().split())) for _ in range(N)]
    check=[[float('inf')]*N for _ in range(N)]
    check[0][0]=board[0][0]

    pq=[]
    pq.append((board[0][0],0,0))
    while pq:
        v,r,c=heapq.heappop(pq)
        if v>check[r][c]:
            continue
        for addr, addc in ((0,1),(1,0),(0,-1),(-1,0)):
            R=r+addr; C=c+addc
            if 0<=R<N and 0<=C<N and v+board[R][C]<check[R][C]:
                check[R][C]=v+board[R][C]
                if not (R==N-1 and C==N-1):
                    heapq.heappush(pq,(v+board[R][C],R,C))
    print("Problem "+str(T)+": "+str(check[N-1][N-1]))

    

