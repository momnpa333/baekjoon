import sys
from collections import Counter

input=sys.stdin.readline
T=int(input())

while T>0:
    originArr=[0]*26
    change=input().strip()
    origin=input().strip()
    
    for o in origin:
        originArr[ord(o)-ord('a')]+=1
    
    for i in range(len(origin)):
        originArr[ord(change[i])-ord('a')]-=1
    for i in originArr:
        if i!=0:
            break
    else:
        print("YES")
        T-=1
        continue
    for i in range(1,len(change)-len(origin)+1):
        originArr[ord(change[i-1])-ord('a')]+=1
        originArr[ord(change[i+len(origin)-1])-ord('a')]-=1
        for i in originArr:
            if i!=0:
                break
        else:
            print("YES")
            break    
    else:
        print("NO")
    T-=1 