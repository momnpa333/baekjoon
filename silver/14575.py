import sys
import math
input=sys.stdin.readline

N,T=map(int,input().split())
minSum=0
maxSum=0
S=0
drink=[list(map(int,input().split()))for i in range(N)]
for i in range(N):
    minSum+=drink[i][0]
    maxSum+=drink[i][1]
#사이값인지 확인
if T<minSum:
    print(-1)
if T>maxSum:
    print(-1)

start=max(math.ceil(T/N),max(drink)[0])

while True:
    start=max(math.ceil(T/N),max(drink)[0])
    totalDrinking=0
    for i in range(N):
        drinking=min(start,drink[i][1])
        drink[i][0]=0
        drink[i][1]-=drinking
        totalDrinking+=drinking
    if totalDrinking<T:
        S+=start
        T-=totalDrinking
    else:
        S+=start
        break
print(S)
