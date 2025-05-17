import sys
input=sys.stdin.readline

sys.setrecursionlimit(10**7)

N,K=map(int,input().split())

coins=[int(input()) for _ in range(N)]

dp=[0]*(K+1)
dp[0]=1
# print(coins)

for coin in coins:
    for i in range(coin,K+1):
        dp[i]+=dp[i-coin]
print(dp[K])