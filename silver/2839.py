import sys
input=sys.stdin.readline

N=int(input())
solv=0
dp=[9999,9999,9999,1,9999,1,2,9999]
for i in range(8,N+1):
    dp.append(min(dp[i-3]+1,dp[i-5]+1))
print(dp)
if dp[N]>=9999:
    print(-1)
else:
    print(dp[N])
