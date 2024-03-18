from itertools import combinations
import copy
from collections import deque

N,M=map(int,input().split(' '))

maze=[list(map(int,input().split(' '))) for _ in range(N)]

zeros=[]

def bfs(newmaze,check,r,c):
    N=len(newmaze); M=len(newmaze[0])
    dq=deque([])
    if check[r][c]==False:
        dq.append((r,c))
        check[r][c] = True

    while dq:
        for _ in range(len(dq)):
            r,c=dq.popleft()
            for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
                newr=addr+r; newc=addc+c
                if 0<=newr<N and 0<=newc<M and check[newr][newc]==False:
                    if newmaze[newr][newc]==0 or newmaze[newr][newc]==2:
                        dq.append((newr,newc))
                        newmaze[newr][newc]=2
                        check[newr][newc]=True


def killer(newmaze):
    check=[[False]*len(newmaze[0]) for _ in range(len(newmaze))]
    for r in range(len(newmaze)):
        for c in range(len(newmaze[0])):
            if newmaze[r][c]==2:
                bfs(newmaze,check,r,c)


def getanswer(walls):
    ret=0
    newmaze=copy.deepcopy(maze)
    for wall in walls:
        newmaze[wall[0]][wall[1]]=1

    killer(newmaze)
    for row in newmaze:
        for item in row:
            if item == 0:
                ret+=1
    return ret

answers=[]

for r in range(N):
    for c in range(M):
        if maze[r][c] == 0:
            zeros.append((r,c))

for walls in combinations(zeros,3):
    answers.append(getanswer(walls))
print(max(answers))
# getanswer(((0,1),(0,2),(0,3)))




