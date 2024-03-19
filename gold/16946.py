import sys
from collections import deque, defaultdict
import copy
input=sys.stdin.readline

N,M=map(int,input().split())

maze=[list(map(int,input().strip()))for _ in range(N)]
answer=copy.deepcopy(maze)
check=[[False]*M for _ in range(N)]
cntdict=defaultdict(int)

def makesection(r,c,section_num,N,M):
    dq=deque([])
    cnt=0
    dq.append((r,c))
    cnt+=1

    maze[r][c]=str(section_num)
    check[r][c]=True
    while dq:
        for _ in range(len(dq)):
            curr,curc=dq.popleft()
            for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
                R=addr+curr; C=addc+curc
                if 0<=R<N and 0<=C<M and check[R][C]==False and maze[R][C]==0:
                    dq.append((R,C))
                    cnt+=1
                    maze[R][C]=str(section_num)
                    check[R][C]=True
    cntdict[str(section_num)]=cnt

def bomb(r,c):
    ret=1
    itemset=set()
    for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
        R=r+addr;C=c+addc
        if 0<=R<N and 0<=C<M:
            if type(maze[R][C])==str:
                itemset.add(maze[R][C])
    for item in itemset:
        ret+=cntdict[item]
    return ret%10

section_num=0
for r in range(N):
    for c in range(M):
        if maze[r][c]==0:
            section_num+=1
            makesection(r,c,section_num,N,M)

for r in range(N):
    for c in range(M):
        if maze[r][c]==1:
            answer[r][c]=bomb(r,c)
answer1=[]

for ans in answer:
    ret=''
    for a in ans:
        ret+=str(a)
    answer1.append(ret)
for item in answer1:
    print(item)
