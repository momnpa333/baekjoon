import sys
from collections import deque
input = sys.stdin.readline
dq=deque()
solve=[]

T=int(input())
while True:
    T-=1
    
    r,c=map(int,input().split())
    dq.append([r,c])
    
    if T ==0:
        break
while True:
    dq=deque(sorted(dq,key=lambda x:(x[0],-x[1]),reverse=True))
    print(dq)
    if dq[0][0]>dq[-1][1]:
        first=dq.pop()
    else:
        first=dq.popleft()
    second=[]
    for idx,i in enumerate(dq):
        if i[0]==first[1]:
            second=list(dq).pop(idx)
            dq.remove(i)
            break
    else:
        second=dq.pop()
        first,second=second,first

    solve.append(first[0]*first[1]*second[1])
    dq.appendleft([first[0],second[1]])
    if len(dq)==1:
        break

print(sum(solve))

    