import sys
from itertools import combinations_with_replacement
input=sys.stdin.readline

N=int(input())

data=sorted([int(input()) for _ in range(N)])
rear=len(data)-1
mid=0
def binary_search(start,end,target):
    global mid
    while start <= end:
        mid = (start + end) // 2

        if data[mid] == target:
            return True
        elif data[mid] < target:
            start = mid + 1
        else:
            end = mid -1

    return False
flag=0
while rear>0:
    left=0
    right=rear-1
    while left<=right:
        target=data[rear]-(data[left]+data[right])
        if binary_search(left,right,target)==True:
            print(data[rear])
            flag=1
            break
        else:
            if mid>(left+right)//2:
                left+=1
            else:
                right-=1

    if flag==1:
        break
    rear-=1