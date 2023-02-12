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
    print(tmp)
    c=0
    while c<=(changeNum-strNum):
        print(c)
        tmp1=sum((Counter(change[c:c+strNum])-tmp).values())
        if tmp1==0:
            print("YES")
            break
        c+=tmp1
    else:print("NO")
    T-=1    