import math
import sys
input=sys.stdin.readline
from collections import deque
prime=[]
for i in range(1000,10000):
    for j in range(2,int(math.sqrt(i))+1):
        if i%j==0:
            break
    else:
        prime.append(i)
print(len(prime))
T=int(input())


def bfs(origin,target):
    dq=deque([])
    flag=0
    cnt=0
    check=[]
    check.append(origin)
    dq.append(origin)
    while dq:
        T=len(dq)
        while T>0:
            T-=1
            tmp=dq.popleft()
            for i in range(4):
                tmp1=list(map(str,str(tmp)))
                for k in range(10):
                    h=''
                    tmp1[i]=str(k)
                    for n in tmp1:
                        h+=n
                    if int(h)==target:
                        print(cnt+1)
                        flag=1
                        break
                    if int(h) in prime and int(h) not in check:
                        check.append(int(h))
                        dq.append(int(h))
                if flag==1:
                    break
            if flag==1:
                    break
        if flag==1:
                    break
        cnt+=1

while T>0:
    T-=1
    origin,target=map(int,input().split())
    if origin==target:
        print(0)
        continue
    bfs(origin,target)


#1033 1733 3733 3739 3779 8779 8179

                








