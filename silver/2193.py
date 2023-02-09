import sys
input=sys.stdin.readline

N=int(input())

# 1    [0,1]
# 10   [1,0]
# 100,101 [1,1]
# 1000,1001,1010 [1+1,1+1-1]
# 10000,10001,10010,10100,10101

dp=[[0,0]for _ in range(91)]
dp[1]=[0,1]
for n in range(2,N+1):
    dp[n][0]=dp[n-1][0]+dp[n-1][1]
    dp[n][1]=dp[n-1][0]

print(sum(dp[N]))