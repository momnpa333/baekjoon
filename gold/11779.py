import sys
import heapq
from collections import deque

input=sys.stdin.readline
N=int(input())
M=int(input())

graph=[[]for _ in range(N+1)]

for _ in range(M):
    a,b,cost=map(int,input().split(' '))
    graph[a].append((b,cost))

start,target=map(int,input().split(' '))

def dikstra(start,target):
    # check=[False]*(N+1)
    costs=[float('inf')]*(N+1)
    via=[[]for _ in range(N+1)]
    q=[]
    heapq.heappush(q,(0,start))
    costs[start]=0
    dq=deque([])

    dq.append(start)
    while q:
        # print(q)
        cost,A=heapq.heappop(q)
        if costs[A]<cost:
            continue
        # check[A]=True
        for B,costB in graph[A]:
            # if check[B]==False:
                if costs[B]>cost+costB:
                    costs[B]=cost+costB
                    via[B]=via[A]+[A]
                    heapq.heappush(q,(costs[B],B))


    print(costs[target])
    print(len(via[target]+[target]))
    print(*(via[target]+[target]))



dikstra(start,target)