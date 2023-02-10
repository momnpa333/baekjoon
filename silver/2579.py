import sys
input=sys.stdin.readline

N=int(input())

stairs=[int(input())for _ in range(N)]
dp=[[0,0]for _ in range(N+1)]


dp[N-1][0]=stairs[N-1]

for i in range(N-2,-1,-1):
    if dp[i+1][1]==1:
        dp[i][0]=dp[i+2][0]+stairs[i]
        dp[i][1]=0
    else:
        if dp[i+1][0]>dp[i+2][0]:
            dp[i][0]=dp[i+1][0]+stairs[i]
            dp[i][1]=1
        else:
            dp[i][0]=dp[i+2][0]+stairs[i]
            dp[i][1]=0
print(dp)
        
