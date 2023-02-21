import sys
from collections import deque
input=sys.stdin.readline
sys.setrecursionlimit(10**7)

R,C=map(int,input().split())

maze=[input().strip() for _ in range(R)]

dq=deque([])
dir=[[1,0],[0,-1],[-1,0],[0,1]]
def bfs():
    cnt=0
    dq.append([0,0,maze[0][0]])
    while dq:
        T=len(dq)
        cnt+=1
        while T>0:
            T-=1
            tmp=dq.popleft()
            for d in dir:
                if 0<=tmp[0]+d[0]<R and 0<=tmp[1]+d[1]<C:
                    if maze[tmp[0]+d[0]][tmp[1]+d[1]] not in tmp[2]:
                        tmp1=tmp[2]
                        tmp1+=maze[tmp[0]+d[0]][tmp[1]+d[1]]
                        dq.append([tmp[0]+d[0],tmp[1]+d[1],tmp1])
    else:
        print(cnt)
bfs()



