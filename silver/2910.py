import sys
from collections import Counter

input = sys.stdin.readline

N,C=map(int,input().split())
NumAry=list(map(int,input().split()))
for (key,value) in sorted(dict(Counter(NumAry)).items(),key=lambda item: item[1],reverse=True) :
    [print(key, end=' ') for _ in range(value)]

