import heapq

N,E=map(int,input().split(' '))
graph=[[] for _ in range(N+1)]
for _ in range(E):
    A,B,cost=map(int,input().split(' '))
    graph[A].append((B,cost))
    graph[B].append((A,cost))
one,two=map(int,input().split(' '))

def dikstra(start,end):
    # print("start",start,"end",end)
    costs=[float('inf')]*(N+1)
    via=[[]for _ in range(N+1)]
    q=[]
    heapq.heappush(q,(0,start))
    costs[start]=0

    while q:
        cost,A=heapq.heappop(q)
        if costs[A]<cost:
            continue
        for B,costB in graph[A]:
            if cost+costB<costs[B]:
                costs[B]=cost+costB
                via[B]=via[A]+[A]
                heapq.heappush(q,(costs[B],B))
    # print(costs[end],via[end])
    return costs[end],via[end]
answer=[]

costOne,viaOne=dikstra(1,one)
costTwo,viaTwo=dikstra(one,two)
costEnd,viaEnd=dikstra(two,N)
answer.append(costOne+costTwo+costEnd)

costTwo,viaTwo=dikstra(1,two)
costOne,viaone=dikstra(two,one)
costEnd,viaEnd=dikstra(one,N)
answer.append(costOne+costTwo+costEnd)
# print(answer)
if min(answer)>=float('inf'):
    print(-1)
else:
    print(min(answer))

