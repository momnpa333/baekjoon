import sys
input=sys.stdin.readline

N=int(input())

board=[list(map(int,input().split())) for _ in range(N)]

dp=[[[0,0,0] for _ in range(N+1)] for _ in range(N+1)]

r=0; c=1

dp[r][c][0]=1

for r in range(N):
    for c in range(N):
        if board[r][c]!=1:
            for op in range(3):
                if op==0:
                    dp[r][c][op]+=(dp[r][c-1][0]+dp[r][c-1][1])
                if op==1:
                    if board[r-1][c]!=1 and board[r][c-1]!=1:
                        dp[r][c][op]+=(sum(dp[r-1][c-1]))
                if op==2:
                    dp[r][c][op]+=(dp[r-1][c][1]+dp[r-1][c][2])
print(sum(dp[N-1][N-1]))
        
