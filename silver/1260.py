import sys
from collections import deque
input=sys.stdin.readline
global N
global M
global V
N,M,V=map(int,input().split())

adjList=[]
for _ in range(N+1):
    adjList.append([])
adjList=deque(adjList)
for _ in range(M):
    S,E=map(int,input().split())
    adjList[S].append(E)
    adjList[E].append(S)
for list in adjList:
    list.sort()


check=[0]*(N+1)
check[V]=1
def dfs(num):
    print(num,end=" ")
    for nod in adjList[num]:
        if check[nod]==0:
            check[nod]=1
            dfs(nod)
dfs(V)
check=[0]*(N+1)
queue=deque([])
queue.append(V)
check[V]=1
print()
print(V,end=" ")
def bfs():
    while queue:
        tmp=queue.popleft()
        for nod in adjList[tmp]:
            if check[nod]==0:
                print(nod,end=" ")
                check[nod]=1
                queue.append(nod)
bfs()


