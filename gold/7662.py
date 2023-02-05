import sys
import heapq

input=sys.stdin.readline

maxheap=[]
minheap=[]
cachy=[]
count=0
idx=0
T=int(input())
for _ in range(T):
    k=int(input())
    check=[0]*(k+1)
    idx=0
    count=0
    flag=0
    maxheap=[]
    minheap=[]
    for _ in range(k):
        commend=input().strip().split()
        if commend[0]=='I':
            count+=1
            idx+=1
            heapq.heappush(minheap,[int(commend[1]),idx])
            heapq.heappush(maxheap,[-1*int(commend[1]),idx])
        if commend[0]=='D':
            if count>0:
                count-=1
            if commend[1]=='1':
                while True:
                    try:
                        tmp=heapq.heappop(maxheap)
                    except:
                        break
                    if tmp is not None:
                        if check[tmp[1]]==0:
                            check[tmp[1]]=1
                            break
            if commend[1]=='-1':
                while True:
                    try:
                        tmp=heapq.heappop(minheap)
                    except:
                        break
                    if tmp != None:
                        if check[tmp[1]]==0:
                            check[tmp[1]]=1
                            break
    while True:
        try:
            tmp=heapq.heappop(maxheap)
        except:
            break
        if tmp is not None:
            if check[tmp[1]]==0:
                print(-1*tmp[0],end=" ")
                flag=1
                break
    while True:
        try:
            tmp=heapq.heappop(minheap)
        except:
            break
        if tmp is not None:
            if check[tmp[1]]==0:
                print(tmp[0])
                flag=1
                break
    if len(minheap)==0 and flag==0:
        print("EMPTY")

