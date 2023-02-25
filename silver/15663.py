import sys
from itertools import permutations

N,M=map(int,input().split())

numary=sorted(list(map(int,input().split())))
check=set()

for i in permutations(numary,M):
    if i not in check:
        print(*i)
        check.add(i)