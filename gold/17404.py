import sys
input=sys.stdin.readline

N=int(input())  

cost=[[0,0,0]]+[list(map(int,input().split())) for _ in range(N)]
R_dp=[[float('inf'),float('inf'),float('inf')] for _ in range(1+N)]
G_dp=[[float('inf'),float('inf'),float('inf')] for _ in range(1+N)]
B_dp=[[float('inf'),float('inf'),float('inf')] for _ in range(1+N)]
R_dp[1][0]=cost[1][0];G_dp[1][1]=cost[1][1];B_dp[1][2]=cost[1][2]
for i in range(2,N+1):
    R_dp[i][0]=min(R_dp[i-1][1],R_dp[i-1][2])+cost[i][0]
    R_dp[i][1]=min(R_dp[i-1][0],R_dp[i-1][2])+cost[i][1]
    R_dp[i][2]=min(R_dp[i-1][1],R_dp[i-1][0])+cost[i][2]
for i in range(2,N+1):
    G_dp[i][0]=min(G_dp[i-1][1],G_dp[i-1][2])+cost[i][0]
    G_dp[i][1]=min(G_dp[i-1][0],G_dp[i-1][2])+cost[i][1]
    G_dp[i][2]=min(G_dp[i-1][1],G_dp[i-1][0])+cost[i][2]
for i in range(2,N+1):
    B_dp[i][0]=min(B_dp[i-1][1],B_dp[i-1][2])+cost[i][0]
    B_dp[i][1]=min(B_dp[i-1][0],B_dp[i-1][2])+cost[i][1]
    B_dp[i][2]=min(B_dp[i-1][1],B_dp[i-1][0])+cost[i][2]
R_dp[N][0]=float('inf');G_dp[N][1]=float('inf');B_dp[N][2]=float('inf')
print(min(min(R_dp[N]),min(G_dp[N]),min(B_dp[N])))