import sys
from collections import deque

N,K=map(int,input().split())
if N==K:
    print(0,1)
    exit(0)
check=set()
def bfs():
    solv=0
    dq=deque([])
    dq.append(N)
    check=[0]*100001
    check2=[0]*100001
    check[N]=1
    count=0
    while dq:
        count+=1
        T=len(dq)
        while T>0:
            tmp=dq.popleft()
            T-=1
            for i in [tmp-1,tmp+1,tmp*2]:
                if 0<=i<=100000:
                    if check[i]==0:
                        if i==K:
                            solv+=1
                        check2[i]=count
                        dq.append(i)
                    if check2[i]==count:
                        check[i]+=check[tmp]
        if solv!=0:
            break
    print(count,check[K])
bfs()



