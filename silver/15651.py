from itertools import product
import sys

input=sys.stdin.readline

N,M=map(int,input().split())
[print(*i) for i in product(range(1,N+1),repeat=M)]
