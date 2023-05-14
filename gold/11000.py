import sys,heapq
input=sys.stdin.readline

N=int(input())
curri=[]
for i in range(N):
    curri.append(list(map(int,input().split(' '))))
curri=sorted(curri,key=lambda x:(x[0], x[1]))

heap=[]
heapq.heappush(heap,0)
for i in curri:
    tmp=heapq.heappop(heap)
    if i[0]>=tmp:
        heapq.heappush(heap,i[1])
    else:
        heapq.heappush(heap,tmp)
        heapq.heappush(heap,i[1])
print(len(heap))