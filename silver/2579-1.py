import sys
input=sys.stdin.readline

N=int(input())

stairs=[int(input())for _ in range(N)]
dp=[[0,0]for _ in range(N+1)]


dp[0][0]=stairs[0]
dp[1][0]=stairs[1]
dp[1][1]=1
if N>1:
    dp[1][0]=stairs[1]+dp[0][0]
    dp[1][1]=1

if (dp[0][0] >dp[1][0]):
    dp[2][1]=0
else:
    dp[2][1]=1
dp[2][0]=max(dp[0][0]+stairs[2],stairs[1]+stairs[2]) 
for i in range(3,N):
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

print(dp)
        
