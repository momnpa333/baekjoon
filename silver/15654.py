import sys
from itertools import permutations

input=sys.stdin.readline

N,M=map(int,input().split())

numAry=sorted(list(map(int,input().split())))
for i in permutations(numAry,M):
    print(*i)