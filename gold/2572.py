import sys
from collections import deque
input=sys.stdin.readline
N=int(input())
op={'R':0,'G':1,'B':2}
card=['E']+list(input().split())

M,K=map(int,input().split())

route=[[set() for _ in range(N+1) ] for _ in range(M+1)]
check=[[0]*(M+1) for _ in range(N+1)]
graph=[[] for _ in range(M+1)]

for _ in range(K):
    S,E,V=input().split()
    S=int(S);E=int(E)
    route[S][E].add(V); route[E][S].add(V)
    graph[S].append(E); graph[E].append(S)
dq=deque([])

dq.append((1,0))
cnt=0
prevM=0
while dq:
    # print(dq)
    cnt+=1
    if cnt>N:
        break
    for _ in range(len(dq)):
        curM=float('inf') 
        S,v=dq.popleft()

        if v+(N-cnt)*10<prevM:
            continue
        if v<check[cnt-1][E]:
            continue
        
        for E in graph[S]:
            # 그 길을 갈때 점수을 얻으면
            if card[cnt] in route[S][E]:
                # 그 길을 갔는데 점수보다 높다면
                if v+10>check[cnt][E]:
                    curM=max(curM,v+10)
                    check[cnt][E]=v+10
                    dq.append((E,v+10))
            else:
                # 그 길을 갔는데 점수보다 높다면
                if v>check[cnt][E]:
                    curM=max(curM,v)
                    check[cnt][E]=v
                    dq.append((E,v))
    else:
        prev=curM
print(max(check[-1]))
