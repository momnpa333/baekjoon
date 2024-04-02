# 통나무 건너뛰기의 난이도는 
# 인접한 두 통나무 간의 높이의 차의 최댓값으로 결정된다
# 인접한 통나무의 높이 차가 최소가 되게 하려 한다.
import heapq
from collections import deque
T=int(input())

def solve(items):
    heapq.heapify(items)
    ret=deque([])
    cnt=0
    while items:
        if cnt%2==0:
            ret.appendleft(heapq.heappop(items))
        else:
            ret.append(heapq.heappop(items))
        cnt+=1
        # print(ret)
    return score(list(ret))

def score(items):
    ret=0
    for item1,item2 in zip(items,items[1:]):
        if ret<abs(int(item1)-int(item2)):
            ret=abs(int(item1)-int(item2))
    if ret<abs(int(items[0])-int(items[-1])):
        ret=abs(int(item1)-int(item2))
    return ret

# def minus(item):
#     return -1*int(item)

for _ in range(T):
    N=int(input())
    items=list(map(int,input().split(" ")))
    print(solve(items))

