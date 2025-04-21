import sys
input=sys.stdin.readline

N,M,K=map(int,input().split())

cur=0;answer=-1
for day in range(1,M+1):
    _,v=map(int,input().split())
    cur+=v
    if answer==-1 and cur>K:
        answer=day

if answer!=-1:
    print(answer,1)
else:
    print(-1)