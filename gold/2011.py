import sys
input=sys.stdin.readline

key_set=set()
for i in range(1,27):
    key_set.add(str(i))
st=" "+input().rstrip()

dp=[0]*(len(st))
dp[0]=1

for idx,s in enumerate(zip(st,st[1:])):
    s1,s2=s
    if s1+s2 in key_set and s2 in key_set:
        dp[idx+1]=dp[idx]+dp[idx-1]
    elif s2 in key_set:
        dp[idx+1]=dp[idx]
    elif s1+s2 in key_set:
        dp[idx+1]=dp[idx-1]
    else:
        print(0)
        exit(0)

print(dp[-1]%1000000)