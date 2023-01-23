import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**7)

global dp
dp=[-1 for _ in range(41)]
dp[0]=[1,0]
dp[1]=[0,1]
def fivonachi(a):
    global dp
    if a==0 or a==1:
        return None
    if dp[a-1]!=-1 and dp[a-2]!=-1:
        dp[a]=[dp[a-1][0]+dp[a-2][0],dp[a-1][1]+dp[a-2][1]]
        return None
    else:
        fivonachi(a-1)
        dp[a]=[dp[a-1][0]+dp[a-2][0],dp[a-1][1]+dp[a-2][1]]
        return None
    



T=int(input())
while T>0:
    N=int(input())
    fivonachi(N)
    print(dp[N][0],dp[N][1])
    T-=1
