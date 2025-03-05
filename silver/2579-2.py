import sys
input=sys.stdin.readline
N=int(input())
item=[]
for _ in range(N):
    item.append(int(input()))
if N<3:
    print(sum(item))
    exit(0)
item=item[::-1]
dp=[0]*N; dp[0]=item[0]; dp[1]=sum(item[:2]); dp[2]=dp[0]+item[2]
#x=12 4 1 34 
#5:f2+35,
for i in range(3,N):
    dp[i]=max(dp[i-3]+item[i-1],dp[i-2])+item[i]
print(max(dp))





