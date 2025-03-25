import sys
sys.setrecursionlimit(10**7)

input=sys.stdin.readline
N=int(input());W=0;B=1
tree=[[] for _ in range(N)]

for _ in range(N-1):
    S,E=map(int,input().split())
    tree[S].append(E)
nums=[list(map(int,input().split())) for _ in range(N)]

dp=[[float('inf'),float('inf')] for _ in range(N)]

def choice_color(root):
    if len(tree[root])==0:
        dp[root][W]=nums[root][W];dp[root][B]=nums[root][B]
        return
    
    white=nums[root][W]; black=nums[root][B]
    for child in tree[root]:
        if dp[child][W]==float('inf'):
            choice_color(child)
        white+=min(dp[child])
        black+=dp[child][W]
    dp[root][W]=white; dp[root][B]=black

choice_color(0)
print(min(dp[0]))
    