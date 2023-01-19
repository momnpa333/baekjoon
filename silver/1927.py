import heapq
import sys
input = sys.stdin.readline

heap = []

for i in range(int(input())):
    N=int(input())
    if(N==0):
        if(len(heap)==0):
            print(0)
        else:
            print(heapq.heappop(heap))
    else:
        heapq.heappush(heap,N)


