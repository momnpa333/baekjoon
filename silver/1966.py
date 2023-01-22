import queue
import sys
input = sys.stdin.readline
queue=queue.Queue()

T=int(input())
solv=[]
count=1
while T>0:
    tmpArray=[]
    M,N=map(int,input().split())
    tmp=list(map(int,input().split()))
    for i in range(M):
        tmpArray.append([tmp[i],i])
    while len(tmpArray):
        maxNum=max(tmpArray)[0]
        if maxNum>tmpArray[0][0]:
            tmpArray.append(tmpArray.pop(0))
        else:
            if tmpArray[0][1]==N:
                print(count)
                break
            else:
                tmpArray.pop(0)
                count+=1
    count=1
    T-=1


