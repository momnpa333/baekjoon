import heapq,sys
input=sys.stdin.readline
N,M=map(int,input().split())
graph=[[]for _ in range(N+1)]
distFox=[float('inf')]*(N+1); distFox[1]=0
distWolf=[[float('inf')]*(N+1) for _ in range(2)]; distWolf[1][1]=0
for _ in range(M):
    A,B,V=map(int,input().split())
    graph[A].append((B,V)); graph[B].append((A,V))

pq=[]
heapq.heappush(pq,(0,1))


# for node,value in graph[1]:
#     heapq.heappush(pq,(node,value))

while pq:
    dist,S=heapq.heappop(pq)
    
    if distFox[S] < dist:  
        continue

    for node,value in graph[S]:
        if dist+value<distFox[node]:
            distFox[node]=dist+value
            heapq.heappush(pq,(dist+value,node))

pq=[]
heapq.heappush(pq,(0,1,0))
while pq:
    dist,S,cnt=heapq.heappop(pq)

    if distWolf[(cnt+1)%2][S]<dist:
        continue

    for node,value in graph[S]:
        if cnt%2==0:
            value=value/2
        else:
            value*=2
        if dist+value<distWolf[cnt%2][node]:
            distWolf[cnt%2][node]=dist+value
            heapq.heappush(pq,(dist+value,node,cnt+1))
wolfFinal=[]

for d1,d2 in zip(distWolf[0],distWolf[1]):
    wolfFinal.append(min(d1,d2))
answer=0
for wolf,fox in zip(wolfFinal,distFox):
    if fox<wolf:
        answer+=1

print(answer)

