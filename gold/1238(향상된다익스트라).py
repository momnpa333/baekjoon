import sys
import heapq

input=sys.stdin.readline
INF=int(1e9)
N,M,X=map(int,input().split())

visited=[False]*(N+1)
distance=[INF]*(N+1)
graph=[[]for _ in range(N+1)]
for i in range(M):
    s,e,c=map(int,input().split())
    graph[s].append((e,c))

def dijkstra(start):
    q=[]
    heapq.heappush(q,(0,start))
    distance[start]=0
    while q:
        dist,node=heapq.heappop(q)
        if distance[node]<dist:
            continue
        for next in graph[node]:
            cost=distance[node]+next[1]
            if cost<distance[next[0]]:
                distance[next[0]]=cost
                heapq.heappush(q,(cost,next[0]))
    

solv=[0]*(N+1)
dijkstra(X)
for i in range(1,N+1):
    solv[i]=distance[i]
distance=[INF]*(N+1)
visited=[False]*(N+1)

for i in range(1,N+1):
    if i==X:
        continue
    distance=[INF]*(N+1)
    visited=[False]*(N+1)
    dijkstra(i)
    solv[i]+=distance[X]
print(max(solv))