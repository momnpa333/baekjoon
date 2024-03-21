T=int(input())
cases=[]
[cases.append(int(input()))for i in range(T)]
dp=[[0]*4 for i in range(max(cases)+1)]

dp[1][1]=1
dp[2][1]=1; dp[2][2]=1
dp[3][1]=1; dp[3][2]=dp[3-2][1]+dp[3-2][2]; dp[3][3]=1

for i in range(4,max(cases)+1):
    dp[i][1]=1
    dp[i][2]=dp[i-2][1]+dp[i-2][2]
    dp[i][3]=dp[i-3][1]+dp[i-3][2]+dp[i-3][3]

for case in cases:
    print(sum(dp[case]))