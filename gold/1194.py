import sys
from collections import deque
sys.setrecursionlimit(10**6)
input=sys.stdin.readline

N,M=map(int,input().split())

maze=[]
for _ in range(N):
    maze.append(list(map(str,input().strip())))
for i in range(N):
    for j in range(M):
        if maze[i][j]=='0':
            start=[i,j,0]
            break
check=[[-1]*M for i in range(N)]
dq=deque([])
dq.append(start)
bitmask=[0,0,0,0,0,0]
def btoi():
    ret=0
    for i in range(6):
        ret+=bitmask[i]*(2**i)
    return ret

dir=[[0,1],[1,0],[0,-1],[-1,0]]
maze[start[0]][start[1]]=btoi()
def ishave(origin,new):
    if origin==-1:
        return False
    a=[0,0,0,0,0,0]
    b=[0,0,0,0,0,0]
    i=0
    while origin>0:
        if origin%2==1:
            a[i]=1
        origin=origin//2
        i+=1
    i=0
    while new>0:
        if new%2==1:
            b[i]=1
        new=new//2
        i+=1
    for i in range(6):
        if b[i]==1 and a[i]==0:
            return False
    return True

def bfs():
    cnt=0
    while dq:
        T=len(dq)
        cnt+=1
        while T>0:
            T-=1
            tmp=dq.popleft()
            for d in dir:
                if 0<=tmp[0]+d[0]<N and 0<=tmp[1]+d[1]<M and maze[tmp[0]+d[0]][tmp[1]+d[1]]!='#' and check[tmp[0]+d[0]][tmp[1]+d[1]]!=tmp[2] and ishave(check[tmp[0]+d[0]][tmp[1]+d[1]],tmp[2])==False:
                    c=0
                    if maze[tmp[0]+d[0]][tmp[1]+d[1]]=='1':
                        print(cnt)
                        exit(0)
                    if maze[tmp[0]+d[0]][tmp[1]+d[1]]=='a':
                        if ((tmp[2]//1)%2)<1:
                            c+=1
                    elif maze[tmp[0]+d[0]][tmp[1]+d[1]]=='b':
                        if ((tmp[2]//2)%2)<1:
                            c+=2
                    elif maze[tmp[0]+d[0]][tmp[1]+d[1]]=='c':
                        if ((tmp[2]//4)%2)<1:
                            c+=4
                    elif maze[tmp[0]+d[0]][tmp[1]+d[1]]=='d':
                        if ((tmp[2]//8)%2)<1:
                            c+=8
                    elif maze[tmp[0]+d[0]][tmp[1]+d[1]]=='e':
                        if ((tmp[2]//16)%2)<1:
                            c+=16
                    elif maze[tmp[0]+d[0]][tmp[1]+d[1]]=='f':
                        if ((tmp[2]//32)%2)<1:
                            c+=32
                    elif maze[tmp[0]+d[0]][tmp[1]+d[1]]=='A':
                        if (tmp[2]%2)<1:
                            continue
                    elif maze[tmp[0]+d[0]][tmp[1]+d[1]]=='B':
                        if ((tmp[2]//2)%2)<1:
                            continue
                    elif maze[tmp[0]+d[0]][tmp[1]+d[1]]=='C':
                        if ((tmp[2]//4)%2)<1:
                            continue
                    elif maze[tmp[0]+d[0]][tmp[1]+d[1]]=='D':
                        if ((tmp[2]//8)%2)<1:
                            continue
                    elif maze[tmp[0]+d[0]][tmp[1]+d[1]]=='E':
                        if ((tmp[2]//16)%2)<1:
                            continue
                    elif maze[tmp[0]+d[0]][tmp[1]+d[1]]=='F':
                        if (tmp[2]//32)%2<1:
                            continue
                    check[tmp[0]+d[0]][tmp[1]+d[1]]=tmp[2]+c
                    dq.append([tmp[0]+d[0],tmp[1]+d[1],tmp[2]+c])

                    
    else:
        print(-1)
bfs()



