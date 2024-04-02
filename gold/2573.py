from collections import deque

M,N=map(int,input().split(" "))
board=[list(map(int,input().split(" "))) for _ in range(M)]

def melt(M,N):
    meltboard=[[0]*N for _ in range(M)]
    for r in range(M):
        for c in range(N):
            if board[r][c]>0:
                for curr,curc in ((0,1),(1,0),(0,-1),(-1,0)):
                    R=r+curr; C=c+curc
                    if 0<=R<M and 0<=C<N:
                        if board[R][C]==0:
                            meltboard[r][c]+=1
    for r in range(M):
        for c in range(N):
            board[r][c]=max(0,board[r][c]-meltboard[r][c])

def isanswer(M,N):
    check=[[False]*N for _ in range(M)]
    cnt=0
    for r in range(M):
        for c in range(N):
            if board[r][c]!=0 and check[r][c]==False:
                check[r][c]=True
                dq=deque([])
                dq.append((r,c))
                while dq:
                    for _ in range(len(dq)):
                        curr,curc=dq.popleft()
                        for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
                            R=curr+addr;C=curc+addc
                            if 0<=R<M and 0<=C<N and check[R][C]==False and board[R][C]!=0:
                                check[R][C]=True
                                dq.append((R,C))
                cnt+=1
    # print(cnt)
    return cnt
answer=0
while True:
    if isanswer(M,N)>=2:
        break
    if isanswer(M,N)==0:
        print(0)
        exit()
    answer+=1
    melt(M,N)
print(answer)

