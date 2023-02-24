import sys
input=sys.stdin.readline

num=list(map(int,input().split()))
N=int(input())
pivot=0
pivot2=len(num)-1
for i in range(N):
    pivot+=1
    num+=list(map(int,input().split()))
    pivot2=len(num)-1-pivot
    num.sort()
    print(num[pivot],num[pivot2])
