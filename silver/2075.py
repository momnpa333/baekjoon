import sys
input=sys.stdin.readline
import heapq
from collections import deque
heap=[]
N=int(input())
#배열 전치하기
ary=[[0 for _ in range(N)]for _ in range(N)]
for i in range(N):
    tmp=list(map(int,input().split()))
    for k in range(N):
        ary[k][i]=tmp[k]
queAray=deque(ary)
tmp=[]
#N개로 첫 힙 구현
answer=0
for j in range(N):
    tmp.append(queAray[j][len(queAray)-1])
    heapq.heappush(heap,-1*queAray[j].pop())
for i in range(N):
    if(i==N-1):
        print(-1*heapq.heappop(heap))
        break
    idx=tmp.index(-1*heapq.heappop(heap))
    tmp[idx]=queAray[idx].pop()
    heapq.heappush(heap,-1*tmp[idx])