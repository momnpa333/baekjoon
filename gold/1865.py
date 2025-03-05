import sys
from collections import deque
input=sys.stdin.readline
TC=int(input())
for _ in range(TC):
    N,M,W=map(int,input().split())
    edges=[];dist=[0]*(N+1);dist[1]=0
    
    for _ in range(M):
        S,E,T=map(int,input().split())
        edges.append((T,S,E)); edges.append((T,E,S))
    for _ in range(W):
        S,E,T=map(int,input().split())
        edges.append((-1*T,S,E))
    
    for _ in range(N-1):
        for t,s,e in edges:
            if dist[s]!=float('inf') and dist[s]+t<dist[e]:
                dist[e]=dist[s]+t
    print(dist)
    answer="NO"
    for t,s,e in edges:
        if dist[s]!=float('inf') and dist[s]+t<dist[e]:
            answer="YES"
            break
    print(dist)
    print(answer)
    

    

    

    
            

    
