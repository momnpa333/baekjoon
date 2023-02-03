import sys
input=sys.stdin.readline

n=int(input())

numary=list(map(int,input().split()))
print(numary)
maxa=-1001
for i in range(len(numary)-1):
    maxa=max(maxa,numary[i]+numary[i+1])
print(maxa)