T,W=map(int,input().split())

dp=[[[0,set()] for _ in range(W+1)] for _ in range(T+1)]

tree=[0]+[int(input()) for _ in range(T)]
# print(tree)
# print(dp)

for i in range(T+1):
    if tree[i]==1:
        dp[i][0][0]=dp[i-1][0][0]+1
    else:
        dp[i][0][0]=dp[i-1][0][0]
    dp[i][0][1].add(1)

for i in range(W+1):
    dp[0][i][1].add(1)


for w in range(1,W+1):
    for i in range(1,T+1):
        if tree[i] in dp[i-1][w][1]:
            dp[i][w][0]=max(dp[i-1][w-1][0]+1,dp[i-1][w][0]+1)
            dp[i][w][1].add(tree[i])
        else:
            if dp[i-1][w-1][0]+1<dp[i-1][w][0]:
                dp[i][w][0]=dp[i-1][w][0]
                dp[i][w][1]|=(dp[i-1][w][1])
            if (dp[i-1][w-1][0]+1)==dp[i-1][w][0]:
                dp[i][w][0]=dp[i-1][w][0]
                dp[i][w][1]|=(dp[i-1][w][1])
                dp[i][w][1].add(tree[i])
            if dp[i-1][w-1][0]+1>dp[i-1][w][0]:
                dp[i][w][0]=dp[i-1][w-1][0]+1
                dp[i][w][1].add(tree[i])


print(dp[T][W][0])