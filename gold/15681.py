import sys
sys.setrecursionlimit(10**7)
input=sys.stdin.readline

N,R,Q=map(int,input().split())
tree=[[] for _ in range(N+1)]

for _ in range(N-1):
    S,E=map(int,input().split())
    tree[S].append(E)
    tree[E].append(S)

dp=[0]*(N+1); check=[True]*(N+1)
check[R]=False
def find_child(root):
    child_num=0
    for child in tree[root]:
        if check[child]==True:
            check[child]=False
            child_num+=find_child(child)
    dp[root]=child_num+1
    return dp[root]

find_child(R)

for _ in range(Q):
    print(dp[int(input())])

    