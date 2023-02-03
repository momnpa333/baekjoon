import sys

N,T=map(int,input().split())

node=[[]for _ in range(N+1)]
want=[]
for i in range(N-1):
    A,B,L=map(int,input().split())
    node[A].append([B,L])
    node[B].append([A,L])

check=[0]*(N+1)
def dfs(start,end,sum):
    if start==end:
        return(print(sum))
    check[start]=1
    for n in node[start]:
        if check[n[0]]==0:
            dfs(n[0],end,sum+n[1])
for _ in range(T):
    S,F=map(int,input().split())
    dfs(S,F,0)
    check=[0]*(N+1)


