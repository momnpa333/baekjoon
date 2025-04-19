import sys
from collections import Counter
input=sys.stdin.readline
sys.setrecursionlimit(10**7)

N=int(input())
M=int(input())

relation=[[] for _ in range(N+1)]

for _ in range(M):
    X,Y,K=map(int,input().split())
    relation[X].append((Y,K))

base=set()
for idx,k in enumerate(relation):
    if idx!=0 and len(k)==0:
        base.add(idx)

dp=[None]*(N+1)

def make_block(idx):
    if dp[idx]!=None:
        return dp[idx]
    
    ret=Counter([])
    for k in base:
        ret[k]=0
    for block,num in relation[idx]:
        if block not in base:
            for k,v in make_block(block).items():
                ret[k]+=v*num
        else:
            ret[block]+=num
    dp[idx]=ret
    return ret

answer=make_block(N)
answer1=[]
for k,v in answer.items():
    answer1.append((k,v))
answer1=sorted(answer1)

for k,v in answer1:
    print(k,v)

