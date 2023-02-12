import sys
from collections import Counter

input=sys.stdin.readline

T=int(input())

while T>0:
    change=input().strip()
    origin=input().strip()
    changeNum=len(change)
    strNum=len(origin)
    tmp=Counter(origin)
    
    for i in range(0,changeNum-strNum+1):
        if Counter(change[i:i+strNum])==tmp:
            print("YES")
            break
    else:
        print("NO")
    T-=1    