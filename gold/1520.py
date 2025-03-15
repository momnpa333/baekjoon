import sys
from collections import deque
sys.setrecursionlimit(10**7)
input=sys.stdin.readline

M,N=map(int,input().split())

board=[list(map(int,input().rstrip().split())) for _ in range(M)]
dp=[[-1]*(N) for _ in range(M)];dp[0][0]=1
def dfs(r,c):
    if r==M-1 and c==N-1:
        return 1
    count=0
    for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
        R=r+addr; C=c+addc
        if 0<=R<M and 0<=C<N:
            #현재 보다 낮다면 더해주기
            if board[R][C]<board[r][c]:
                #갱신된적이 있다면
                if dp[R][C]!=-1:
                    count+=dp[R][C]
                else:
                    count+=dfs(R,C)
    dp[r][c]=count
    return dp[r][c]
print(dfs(0,0))