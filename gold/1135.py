import sys, heapq
sys.setrecursionlimit(10**7)

input=sys.stdin.readline

N=int(input())

value=[0]*N
tree=[[] for _ in range(N)]
emp=list(map(int,input().split()))

for cur,pre in enumerate(emp[1:]):
    tree[pre].append(cur+1)

def find_time(pre):
    if len(tree[pre])==0:
        return 0

    pq=[]

    for child in tree[pre]:
        heapq.heappush(pq,(-(find_time(child)),child))


    ret=0;time=0
    while pq:
        time+=1
        v,e=heapq.heappop(pq)
        ret=max(ret,-v+time)

    return ret
    
print(find_time(0))


