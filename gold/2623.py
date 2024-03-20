from collections import deque

N,M=map(int,input().split(' '))

watchnum=[0]*(N+1)
watchnum[0]=987654321

graph=[[] for _ in range(N+1)] 

for i in range(M):
    singers=list(map(int,input().split(' ')))[1:]
    for a,b in zip(singers,singers[1:]):
        # print(a,b)
        graph[a].append(b)
        watchnum[b]+=1
dq=deque([])
answer=[]
for idx,item in enumerate(watchnum):
    if item ==0:
        dq.append(idx)
        answer.append(idx)

# print(answer)

while dq:
    for _ in range(len(dq)):
        item=dq.popleft()
        while graph[item]:
            watched=graph[item].pop()
            watchnum[watched]-=1
            if watchnum[watched]==0:
                dq.append(watched)
                answer.append(watched)
if len(answer)==N:
    for i in answer:
        print(i)
else:
    print(0)