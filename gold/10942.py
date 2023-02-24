import sys
input=sys.stdin.readline

N=int(input())
numAry=list(map(int,input().split()))
M=int(input())
cmd=[]

def fellindrom(start,finish):
    while start<=finish:
        if numAry[start]==numAry[finish]:
            start+=1
            finish-=1
        else:
            return 0
    return 1

for i in range(M):
    a,b=map(int,input().split())
    print(fellindrom(a-1,b-1))