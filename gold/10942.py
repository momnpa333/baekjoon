import sys
input=sys.stdin.readline

N=int(input())
numAry=list(map(int,input().split()))
M=int(input())
dp=[[True]*(N)for _ in range(N)]

for gap in range(1,N):
    for S in range(N-gap):
        E=S+gap
        if dp[S+1][E-1]==True and numAry[E]==numAry[S]:
            dp[S][E]=True 
        else:
            dp[S][E]=False
print(dp)


for i in range(M):
    a,b=map(int,input().split())
    if dp[a-1][b-1]==True:
        print(1)
    else:
        print(0)
