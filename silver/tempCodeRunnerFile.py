import sys
input=sys.stdin.readline

N=int(input())

stairs=[int(input())for _ in range(N)]
dp=[[0,0]for _ in range(N+1)]


dp[0][0]=stairs[0]
if N>1:
    dp[1][0]=stairs[1]+dp[0][0]
    dp[1][1]=1
for i in range(1,N):
    if dp[i-1][1]==1:
        dp[i][0]=dp[i-2][0]+stairs[i]
        dp[i][1]=0
    else:
        if dp[i-1][0]>dp[i-2][0]:
            dp[i][0]=dp[i-1][0]+stairs[i]
            dp[i][1]=1
        else:
            dp[i][0]=dp[i-2][0]+stairs[i]
            dp[i][1]=0
print(dp[N-1][0])
        
