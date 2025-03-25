import sys,heapq
sys.setrecursionlimit(10**7)
input=sys.stdin.readline

N=int(input())

nums=[0]+list(map(int,input().split()))
tree=[[]for _ in range(1+N)]
for _ in range(N-1):
    S,E=map(int,input().split())
    tree[S].append(E); tree[E].append(S)
check=[True]*(1+N); check[1]=False
dp=[[0,0] for _ in range(1+N)]

def choice_good(root):
    no_cnt=0; choice_cnt=0
    for child in tree[root]:
        if check[child]==True:
            check[child]=False
            choice_good(child)
        no_cnt+=max(dp[child])
        choice_cnt+=dp[child][0]
    dp[root][0]=no_cnt; dp[root][1]=choice_cnt+nums[root]

choice_good(1)
print(max(dp[1]))
    
    
    
    