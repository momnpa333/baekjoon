import sys
input=sys.stdin.readline
import heapq
N,M=map(int,input().split())
graph=[[]for _ in range(N+1)] 
value=[0]*(N+1)
for _ in range(M):
    S,E,V=map(int,input().split())
    graph[S].append((V,E));graph[E].append((V,S))
F1,F2=map(int,input().split())

pq=[]
heapq.heappush(pq,(-float('inf'),F1))
check=[True]*(N+1);check[F1]=False; value[F1]=float('inf')
while pq:
    v,s=heapq.heappop(pq)
    # print(v,s)
    if value[s]>-v:
        continue
    for gram,node in graph[s]:
        # print(-v,gram)
        # print(min(-v,gram))
        if value[node]<min(-v,gram):
            value[node]=min(-v,gram)
            heapq.heappush(pq,(-min(-v,gram),node))

print(value[F2])
