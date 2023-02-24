import sys
from itertools import combinations
input=sys.stdin.readline

N=int(input())
diet=list(map(int,input().split()))
count=0
for i in combinations(diet,3):
    if 2000<=(sum(i))<=2500:
        count+=1
print(count)
