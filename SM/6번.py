import sys
input=sys.stdin.readline

N,M=map(int,input().split())

check=[0]*(N+1)
money=[0]*(N+1)

adjgraph=[[]for i in range(N+1)]
for i in range(M):
    a,b,cost=map(int,input().split())
    adjgraph[a].append((b,cost))
    adjgraph[b].append((a,cost))
for i in range(N-1):
    a,b=map(int,input().split())
    money[a]=b

def dfs(a,cost):
    for v in adjgraph[a]:
        if check[v[0]]==0:
            check[v[0]]=cost+v[1]
            dfs(v[0],cost+v[1])
check[1]=-1
dfs(1,0)
profit=0
answer=0
for i in range(2,N+1):
    p=money[i]-check[i]*2
    if profit<p:
        profit=p
        answer=i
print(answer,profit)
    

