import sys
input=sys.stdin.readline
from collections import deque
N,M=map(int,input().split())

maze=[]
for _ in range(N):
    maze.append(list(map(int,input().strip())))
dir=[[0,1],[1,0],[0,-1],[-1,0]]
queue=deque([])
queue.append([0,0])

count=1
maze[0][0]=count
def bfs():
    global count
    while queue:
        count+=1
        T=len(queue)
        while T>0:
            tmp=queue.popleft()
            for r,c in dir:
                if 0<=(tmp[0]+r)<N and 0<=(tmp[1]+c)<M and maze[tmp[0]+r][tmp[1]+c]==1:
                    maze[tmp[0]+r][tmp[1]+c]=count
                    queue.append([tmp[0]+r,tmp[1]+c])
            else:
                T-=1
bfs()
print(maze[N-1][M-1])

