import sys
input=sys.stdin.readline

N,M=map(int,input().split())
parent=[i for i in range(N+1)]
edges=[]
def findparent(v):
    if parent[v]!=v:
        parent[v]=findparent(parent[v])
    return parent[v]

def unionparent(a,b):
    A=findparent(a)
    B=findparent(b)
    if A<B:
        parent[B]=A
    else:
        parent[A]=B
    


for _ in range(M):
    v1,v2,cost=map(int,input().split())
    edges.append((v1,v2,cost))
edges.sort(key=lambda x:x[2])

res=0
last=0
for edge in edges:
    a,b,cost=edge
    if findparent(a)!=findparent(b):
        unionparent(a,b)
        res+=cost
        last=cost

print(res-last)