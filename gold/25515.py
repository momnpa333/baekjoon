import sys
sys.setrecursionlimit(10**7)
input=sys.stdin.readline
N=int(input())
tree=[[] for _ in range(N)]

dp=[0]*N

for _ in range(N-1):
    S,E=map(int,input().split())
    tree[S].append(E)
nums=list(map(int,input().split()))

def find_max_value(root):
    value=0
    if len(tree[root])==0:
        dp[root]=nums[root]
        return dp[root]

    for child in tree[root]:
        child_value=find_max_value(child)
        if child_value>0:
            value+=child_value
    dp[root]=value+nums[root]
    return dp[root]

print(find_max_value(0))



