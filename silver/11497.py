import sys
input=sys.stdin.readline
from collections import deque
dq=deque()
tree=deque()
T=int(input())
answer=0
while T>0:
    N=int(input())

    tree=sorted(list(map(int,input().split())))
    dq.append(tree.pop())
    while len(tree)>0:
        if len(dq)%2==1:
            dq.appendleft(tree.pop())
            if answer<abs(dq[0]-dq[1]):
                answer=abs(dq[0]-dq[1])
        else:
            dq.append(tree.pop())
            if answer<abs(dq[-1]-dq[-2]):
                answer=abs(dq[-1]-dq[-2])
    print(answer)
    dq.clear()
    tree.clear()
    T-=1
    answer=0
        
        
    