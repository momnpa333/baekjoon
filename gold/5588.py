import sys
from collections import Counter
input=sys.stdin.readline

dic={}

m=int(input())
find=sorted(list(map(int, input().split())) for _ in range(m))
n=int(input())
starList=sorted(list(map(int, input().split())) for _ in range(n))

tmp=[(starList[j][0]-find[i][0],starList[j][1]-find[i][1]) for i in range(m) for j in range(n)]
print(Counter(tmp).most_common()[0][0][0],Counter(tmp).most_common()[0][0][1])