import sys,heapq
input=sys.stdin.readline

T=int(input())
for _ in range(T):
    N,D,C=map(int,input().split())
    graph=[[]for _ in range(N+1)]; dist=[float('inf')]*(N+1); dist[C]=0
    pq=[]
    for _ in range(D):
        E,S,V=map(int,input().split())
        graph[S].append((V,E))
    heapq.heappush(pq,(0,C))
    while pq:
        V,S=heapq.heappop(pq)
        if V>dist[S]:
            continue
        for value,E in graph[S]:
            if V+value<dist[E]:
                dist[E]=V+value
                heapq.heappush(pq,(V+value,E))
    cnt=0; big=0
    for d in dist:
        if d!=float('inf'):
            cnt+=1
            big=max(big,d)
    print(cnt,big)
    
    