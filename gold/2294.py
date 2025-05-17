import sys
input=sys.stdin.readline

N,K=map(int,input().split())

coins=[int(input()) for _ in range(N)]

dp=[float('inf')]*(K+1)

dp[0]=0

for coin in coins:
    for i in range(coin,K+1):
        dp[i]=min(dp[i-coin]+1,dp[i])
if dp[K]!=float('inf'):
    print(dp[K])
else:
    print(-1)