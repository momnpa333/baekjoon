import sys

input=sys.stdin.readline

N=int(input())

house=sorted(list(map(int,input().split())))

print(house[(N-1)//2])