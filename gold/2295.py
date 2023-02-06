import sys
from itertools import combinations_with_replacement
input=sys.stdin.readline

N=int(input())

numary=[int(input()) for _ in range(N)]
rear=len(numary)-1
ans={}
#두수의합
sumary=set()
for i in numary:
    for j in numary:
        sumary.add(i+j)
#두수의 차

subary=set()
for i in numary:
    for j in numary:
        if (i-j) in sumary:
            ans[i]=(i,j,i-j)
answer=sorted(list(ans.keys()))
print(answer[len(answer)-1])