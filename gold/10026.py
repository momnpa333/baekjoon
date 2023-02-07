import sys
from collections import deque
N=int(input())

drawing=[list(input().strip()) for _ in range(N)]
count=0
countBlind=0
blind=[list("B"*N) for _ in range(N)]
for i in range(N):
    for j in range(N):
        if drawing[i][j] =="R":
            blind[i][j]='G'
        else:
            blind[i][j]=drawing[i][j]
dir=[[0,1],[1,0],[0,-1],[-1,0]]
queue=deque([])
def bfs(S):
    while queue:
        tmp=queue.popleft()
        for r,c in dir:
            if 0<=(tmp[0]+r)<N and 0<=(tmp[1]+c)<N and drawing[tmp[0]+r][tmp[1]+c]==S:
                drawing[tmp[0]+r][tmp[1]+c]='Z'
                queue.append([tmp[0]+r,tmp[1]+c])
def blindbfs(S):
    while queue:
        tmp=queue.popleft()
        for r,c in dir:
            if 0<=(tmp[0]+r)<N and 0<=(tmp[1]+c)<N and blind[tmp[0]+r][tmp[1]+c]==S:
                blind[tmp[0]+r][tmp[1]+c]='Z'
                queue.append([tmp[0]+r,tmp[1]+c])
for i in range(N):
    for j in range(N):
        tmp=drawing[i][j]
        tmpblind=blind[i][j]
        if drawing[i][j]!='Z':
            count+=1
            drawing[i][j]='Z'
            queue.append([i,j])
            bfs(tmp)
        if blind[i][j]!='Z':
            countBlind+=1
            blind[i][j]='Z'
            queue.append([i,j])
            blindbfs(tmpblind)
print(count,countBlind)

