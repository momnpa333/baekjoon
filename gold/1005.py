from collections import deque
import sys
input=sys.stdin.readline


T=int(input())

def game(N,K):
    graph=[[0,-1,[]]for _ in range(N+1)]
    costs=list(map(int,input().split(" ")))
    prevnum=[0]*(N+1)
    prevnum[0]=float('-inf')
    for idx,cost in enumerate(costs):
        graph[idx+1][0] = cost
    for _ in range(K):
        a,b=map(int,input().split(' '))
        graph[a][2].append(b)
        prevnum[b]+=1
    W=int(input())
    dq=deque([])
    # dq.append((W,0))
    for idx,num in enumerate(prevnum):
        if num==0:
            dq.append((idx,0))

    while dq:
        # print(dq)
        for _ in range(len(dq)):
            item,prevcost=dq.popleft()
            graph[item][1]=max(graph[item][1],graph[item][0]+prevcost)
            # answer=max(answer,graph[item][1])
            while graph[item][2]:
                target=graph[item][2].pop()
                prevnum[target]-=1
                graph[target][1]=max(graph[target][1],graph[item][1]+graph[target][0])
                if prevnum[target]==0:
                    dq.append((target,graph[item][1]))
                    # check.add(target)
    print(graph[W][1])
    # for idx,num in enumerate(prevnum):


for _ in range(T):
    N,K=map(int,input().split(' '))
    game(N,K)