import sys, heapq
input=sys.stdin.readline
N,M=map(int,input().split())

board=[list(map(str,input().rstrip())) for _ in range(N)]
check=[[[float('inf'),float('inf')] for _ in range(M)] for _ in range(N)]

pq=[]
SR=0;SC=0
for r in range(N):
    for c in range(M):
        if board[r][c]=="S":
            SR=r; SC=c
        if board[r][c]==".":
            for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
                R=r+addr; C=c+addc
                if 0<=R<N and 0<=C<M and board[R][C]=="g":
                    board[r][c]="T"

heapq.heappush(pq,(0,0,SR,SC))

check[SR][SC][0]=0; check[SR][SC][1]=0

while pq:
    v1,v2,r,c=heapq.heappop(pq)
    if check[r][c][0]<v1:
        continue
    if check[r][c][0]==v1 and check[r][c][1]<v2:
        continue

    for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
        R=r+addr; C=c+addc
        if 0<=R<N and 0<=C<M:
            if board[R][C]=="F":
                print(v1,v2)
                exit(0)

            if board[R][C]=="T":
                if check[R][C][0]>v1 or (check[R][C][0]==v1 and check[R][C][1]>v2+1):
                    check[R][C][0]=v1; check[R][C][1]=v2+1
                    heapq.heappush(pq,(v1,v2+1,R,C))
            elif board[R][C]=="g":
                if check[R][C][0]>v1+1 or (check[R][C][0]==v1+1 and check[R][C][1]>v2):
                    check[R][C][0]=v1+1; check[R][C][1]=v2
                    heapq.heappush(pq,(v1+1,v2,R,C))   
            elif board[R][C]==".":
                if check[R][C][0]>v1 or (check[R][C][0]==v1 and check[R][C][1]>v2):
                    check[R][C][0]=v1; check[R][C][1]=v2
                    heapq.heappush(pq,(v1,v2,R,C))       






