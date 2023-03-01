import sys
from itertools import combinations

input=sys.stdin.readline

N,M=map(int,input().split())

numAry=sorted(list(map(int,input().split())))
for i in combinations(numAry,M):
    print(*i)