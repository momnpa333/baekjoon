from collections import deque

N,M=map(int,input().split(' '))

graph=[[] for i in range(N+1)]

watchnum=[0]*(N+1)
watchnum[0]=987654321
for _ in range(M):
    a,b=map(int,input().split(" "))
    graph[a].append(b)
    watchnum[b]+=1

def findNoWatch():
    ret=[]
    for idx,watch in enumerate(watchnum):
        if watch==0:
            ret.append(idx)
    return ret

answer=[]
nowatches=findNoWatch()
dq=deque([])
for item in nowatches:
    dq.append(item)
    answer.append(item)

while dq:
    # print(dq)
    for _ in range(len(dq)):
        target=dq.popleft()
        while graph[target]:
            watch=graph[target].pop()
            watchnum[watch]-=1
            if watchnum[watch]==0:
                answer.append(watch)
                dq.append(watch)
print(*answer)


        

