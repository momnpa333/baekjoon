import sys

input=sys.stdin.readline
INF=int(1e9)
N,M,X=map(int,input().split())

visited=[False]*(N+1)
distance=[INF]*(N+1)
graph=[[]for _ in range(N+1)]
for i in range(M):
    s,e,c=map(int,input().split())
    graph[s].append((e,c))

#방문하지 않은 노드이면서 시작노드와 최단거리
def get_smallest_node():
    min_value=INF
    index=0
    for i in range(1,N+1):
        if not visited[i] and distance[i]<min_value:
            min_value=distance[i]
            index=i
    return index

def dijkstra(start):
    distance[start]=0
    visited[start]=True

    for i in graph[start]:
        distance[i[0]]=i[1]
    for _ in range(N-1):
        now=get_smallest_node()
        visited[now]=True
        for next in graph[now]:
            cost=distance[now]+next[1]
            if cost<distance[next[0]]:
                distance[next[0]]=cost

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