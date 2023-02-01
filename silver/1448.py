from itertools import combinations
import sys
input = sys.stdin.readline

ary=[0 for _ in range(1000001)]
N=int(input())
for _ in range(N):
    ary[int(input())]+=1
#print(ary)
straw=[]
for i in range(len(ary)):
    for _ in range(ary[i]):
        straw.append(i)

solv=0
for i in range(N-2):
    for j in range(i+1,N-1):
        for k in range(j+1,N):
            if straw[i]+straw[j]>straw[k]:
                solv=straw[i]+straw[j]+straw[k]
if solv==0:
    solv=-1
print(solv)