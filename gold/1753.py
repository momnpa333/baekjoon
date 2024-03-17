import sys
import heapq

input=sys.stdin.readline
INF=int(1e9)
N,M=map(int,input().split())
X=int(input())
visited=[False]*(N+1)
distance=[INF]*(N+1)
graph=[[]for _ in range(N+1)]


for i in range(M):
    s,e,c=map(int,input().split())
    graph[s].append((e,c))
print(graph)
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
    

dijkstra(X)
for i in range(1,N+1):
    if distance[i] ==INF:
        print("INF")
    else :
        print(distance[i])
    