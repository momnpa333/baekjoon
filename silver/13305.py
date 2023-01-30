import sys
input=sys.stdin.readline
N=int(input())
road=list(map(int,input().split()))
oils=list(map(int,input().split()))

minoil=1000000000
price=0

for i in range(len(road)):
    minoil=min(minoil,oils[i])
    price+=minoil*road[i]
print(price)

