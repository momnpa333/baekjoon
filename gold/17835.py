import heapq
import sys
input=sys.stdin.readline
N,M,K=map(int,input().split(' '))

graph=[[]for _ in range(N+1)]

for _ in range(M):
    B,A,V=map(int,input().split(' '))
    graph[A].append((B,V))

targets=list(map(int,input().split(' ')))

def dikstra():
    costs=[float('inf')]*(N+1)
    # costs[start]=0
    for target in targets:
        costs[target]=0
    # print(graph)
    q=[]
    for target in targets:
        heapq.heappush(q,(target,0))
    while q:
        start_node,cur_cost=heapq.heappop(q)
        if costs[start_node]<cur_cost:
            continue   
        for end_node,add_cost in graph[start_node]:
            if cur_cost+add_cost<costs[end_node]:
                costs[end_node]=cur_cost+add_cost
                heapq.heappush(q,(end_node,cur_cost+add_cost))
    return costs

# answer=[-1,-1]
costs=[float('inf')]*(N+1)
answer=dikstra()

# print(answer)

answer1=[-1,-1]

for idx,ans in enumerate(answer[1:]):
    if ans>answer1[1]:
        answer1[0]=idx+1
        answer1[1]=ans
print(answer1[0])
print(answer1[1])
