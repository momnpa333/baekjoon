import sys
input=sys.stdin.readline
N=int(input())
T=list(map(int,input().split()))
T=sorted(T)
S=0
answer=0
for t in T:
    S=S+t
    answer+=S
print(answer)