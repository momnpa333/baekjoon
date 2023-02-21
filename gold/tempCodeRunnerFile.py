import sys
from collections import deque
input=sys.stdin.readline
sys.setrecursionlimit(10**7)

R,C=map(int,input().split())

maze=[input().strip() for _ in range(R)]

dir=[[1,0],[0,-1],[-1,0],[0,1]]
answer=set()
def dfs(row,col,check,depth):
    for d in dir:
        if 0<=row+d[0]<R and 0<=col+d[1]<C:
            if maze[row+d[0]][col+d[1]] not in check:
                dfs(row+d[0],col+d[1],check+maze[row+d[0]][col+d[1]],depth+1)
    answer.add(depth)
dfs(0,0,maze[0][0],1)
print(max(answer))

