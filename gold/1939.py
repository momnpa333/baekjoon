import sys
input=sys.stdin.readline
from collections import deque
N,M=map(int,input().split())
graph=[[]for _ in range(N+1)] 
value=[0]*(N+1)
for _ in range(M):
    S,E,V=map(int,input().split())
    graph[S].append((V,E));graph[E].append((V,S))
F1,F2=map(int,input().split())

dq=deque([])
dq.append((float('inf'),F1))
check=[True]*(N+1)
while dq:
    for _ in range(len(dq)):
        g,edge=dq.popleft()
        for v,node in graph[edge]:
            cur=min(g,v)
            if value[node]<cur:
                value[node]=cur
                dq.append((cur,node))
print(value[F2])
