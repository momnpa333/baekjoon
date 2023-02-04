import sys
sys.setrecursionlimit(10**7)
input=sys.stdin.readline
from collections import deque

N,K=map(int,input().split())
dq=deque([])
check=[0]*100001
def bfs():
    global K
    depth=0
    while dq:
        T=len(dq)
        depth+=1
        while T>0:
            pos=dq.popleft()
            if pos-1>=0 and check[pos-1]==0:
                if pos-1==K:
                    return depth
                check[pos-1]=1
                dq.append(pos-1)
            if pos+1<=100000 and check[pos+1]==0:
                if pos+1==K:
                    return depth
                check[pos+1]=1
                dq.append(pos+1)
            if pos*2<=100000 and check[pos*2]==0 :
                if pos*2==K:
                    return depth
                check[pos*2]=1
                dq.append(pos*2)
            T-=1
dq.appendleft(N)
check[N]=1
if N==K:
    print(0)
else:
    print(bfs())

