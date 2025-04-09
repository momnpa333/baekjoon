import sys
import heapq
input=sys.stdin.readline
N=int(input()); M=int(input())
graph=[[]for _ in range(N+1)]; check=[False]*(N+1); dist=[float('inf')]*(N+1)
for _ in range(M):
    A,B,d=map(int,input().split())
    graph[A].append((d,B))
S,E=map(int,input().split())
pq=[]; dist[S]=0
heapq.heappush(pq,(0,S))

while pq:
    D,cur=heapq.heappop(pq)
    if check[cur]==False:
        check[cur]=True
    else:
        continue
    for di,node in graph[cur]:
        if (D+di)<dist[node] and check[node]==False:
            dist[node]=D+di
            heapq.heappush(pq,(D+di,node))
print(dist[E])
