import sys
from itertools import combinations_with_replacement
input=sys.stdin.readline

N=int(input())

numary=sorted([int(input()) for _ in range(N)])
rear=len(numary)-1

left=0
right=rear-1

mid=(left+right)//2
front=left
back=right
flag=0
while rear>0:
    while True:
        if numary[left]+numary[right]+numary[mid]==numary[rear]:
            print(numary[rear])
            flag=1
            break
        elif numary[left]+numary[right]+numary[mid]>numary[rear]:
            back=mid
            mid=(mid+front)//2
        elif numary[left]+numary[right]+numary[mid]<numary[rear]:
            front=mid
            mid=(mid+back+1)//2
        if front==back or mid==back or mid==front:
            if numary[left]+numary[right]+numary[mid]==numary[rear]:
                print(numary[rear])
                flag=1
                break
            else:
                if mid>(left+right)//2:
                    left+=1
                    front=left
                    back=right
                    mid=(left+right)//2
                else:
                    right-=1
                    front=left
                    back=right
                    mid=(left+right)//2
       
        if left==right:
            if numary[left]+numary[right]+numary[mid]==numary[rear]:
                print(numary[rear])
                flag=1
                break
            else:
                rear-=1
                left=0
                right=rear-1
                break
    if flag==1:
        break



