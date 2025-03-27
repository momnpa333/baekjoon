import sys,heapq
from collections import Counter
input=sys.stdin.readline

N=int(input())

A=[];B=[];C=[];D=[]

for _ in range(N):
    a,b,c,d=map(int,input().split())
    A.append(a);B.append(b);C.append(c);D.append(d)

AB=[];CD=[]
for a in A:
    for b in B:
        AB.append(a+b)
ABD=Counter(AB)
answer=0
for c in C:
    for d in D:
        K=c+d
        if -K in ABD:
            answer+=ABD[-K]
print(answer)




    