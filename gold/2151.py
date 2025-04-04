import sys,heapq
input=sys.stdin.readline

N=int(input())

board=[list(map(str,input().rstrip())) for _ in range(N)]
check=[[[float('inf')]*4 for _ in range(N)]for _ in range(N)]
# print(check)
# print(board)
door=[]
for r in range(N):
    for c in range(N):
        if board[r][c]=="#":
            door.append((r,c))
S,E=door;D=((0,1),(1,0),(0,-1),(-1,0))
pq=[]
for dir in range(4):
    heapq.heappush(pq,(0,S[0],S[1],dir))
    check[S[0]][S[1]][dir]=0

while pq:
    # print(pq)
    cnt,curr,curc,dir=heapq.heappop(pq)

    if cnt>check[curr][curc][dir]:
        continue

    R=curr+D[dir][0]; C=curc+D[dir][1]
    if 0<=R<N and 0<=C<N:
        if R==E[0] and C==E[1]:
            print(cnt)
            exit(0)
        if board[R][C]==".":
            if check[R][C][dir]>cnt:
                check[R][C][dir]=cnt
                heapq.heappush(pq,(cnt,R,C,dir))
        elif board[R][C]=="!":
            if check[R][C][(dir+3)%4]>cnt+1:
                check[R][C][(dir+3)%4]=cnt+1
                heapq.heappush(pq,(cnt+1,R,C,(dir+3)%4))
            if check[R][C][(dir+1)%4]>cnt+1:
                check[R][C][(dir+1)%4]=cnt+1
                heapq.heappush(pq,(cnt+1,R,C,(dir+1)%4))
            if check[R][C][dir]>cnt:
                check[R][C][dir]=cnt
                heapq.heappush(pq,(cnt,R,C,dir))


