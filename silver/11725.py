import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**7)

N=int(input())

edges=[]
for i in range(N+1):
    edges.append([])

for _ in range(N-1):
    i,j=map(int,input().split())
    edges[i].append(j)
    edges[j].append(i)


check=[0]*(N+1)
solv=[0]*(N+1)
def dfs(start,depth):
    check[start]=1
    for edge in edges[start]:
        if check[edge]==0:
            solv[edge]=start
            dfs(edge,depth)
dfs(1,0)
for i in range(2,N+1):
    print(solv[i])