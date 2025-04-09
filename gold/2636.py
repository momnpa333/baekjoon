from collections import deque
N,M=map(int,input().split())

board=[list(map(int,input().split())) for _ in range(N)]

dq=deque([])

boundR,boundC=N,M
time=0;answer=0
while boundR>N//2 or boundC//M:
    check=[[False]*boundC for _ in range(boundR)]
    dq.append((boundR-1,boundC-1)); check[boundR-1][boundC-1]=True
    cnt=0; meltSet=set()

    while dq:
        for _ in range(len(dq)):
            r,c=dq.popleft()
            for curr,curc in ((0,1),(1,0),(0,-1),(-1,0)):
                R=curr+r; C=curc+c
                if 0<=R<boundR and 0<=C<boundC and check[R][C]==False:
                    check[R][C]=True
                    if board[R][C]==1:
                        meltSet.add((R,C)); cnt+=1
                    else:
                        dq.append((R,C))
    for r,c in meltSet:
        board[r][c]=0
    if cnt==0:
        break
    else:
        answer=cnt
    boundR-=1;boundC-=1
    time+=1

print(time)
print(answer)




