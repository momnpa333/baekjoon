T=int(input())
cases=[]
[cases.append(int(input()))for i in range(T)]
dp=[0]*11
dp[0]=0;dp[1]=1;dp[2]=2;dp[3]=3

for i in range(4,max(cases)):
    dp[i]=dp[i-1]+dp[i-2]+1
print(dp)