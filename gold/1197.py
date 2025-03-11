import heapq
import sys
sys.setrecursionlimit(10**7)
input=sys.stdin.readline
V,E=map(int,input().split())

parent=[i for i in range(V+1)]
graph=[[] for _ in range(V+1)]
pq=[]

for _ in range(E):
    A,B,value=map(int,input().split())
    heapq.heappush(pq,(value,A,B))
    graph[A].append((B,value)); graph[B].append((A,value))

def findParent(node):
    if node==parent[node]:
        return node
    parent[node]=findParent(parent[node])
    return parent[node]


def unionFind(a,b):
    A=findParent(a); B=findParent(b)
    if A<B:
        parent[B]=A
    else:
        parent[A]=B

edgeNum=0; totalLength=0
while True:
    if edgeNum==V-1:
        break
    value,A,B=heapq.heappop(pq)

    if findParent(A)!=findParent(B):
        unionFind(A,B)
        edgeNum+=1; totalLength+=value
print(totalLength)
        

