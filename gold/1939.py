N,M=map(int,input().split())
graph=[[]for _ in range(N+1)] 
parent=[(i,0) for i in range(N+1)]
for _ in range(M):
    S,E,V=map(int,input().split())
    graph[S].append((V,E));graph[E].append((V,S))
F1,F2=map(int,input().split())

