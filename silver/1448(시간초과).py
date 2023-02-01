from itertools import combinations
import sys
input = sys.stdin.readline

ary=[0 for _ in range(1000001)]
N=int(input())
for _ in range(N):
    ary[int(input())]+=1
#print(ary)
straw=[]
for i in range(len(ary)-1,-1,-1):
    for _ in range(ary[i]):
        straw.append(i)
solv=0
flag=0

for i in range(N-2):
    if straw[i]<straw[i+1]+straw[i+2]:
        flag=1
        solv=straw[i]+straw[i+1]+straw[i+2]
        break
else:
    solv=-1

print(solv)