import sys
input=sys.stdin.readline

N,M=map(int,input().rstrip().split(' '))
graph=[[] for _ in range(N+1)]
for i in range(M):
    a,b=map(int,input().rstrip().split(' '))
    graph[a].append(b)
    graph[b].append(a)

def dfs(depth,friend,check):
    # print(check)
    if depth==4:
        print(1)
        exit()
    for item in graph[friend]:
        if item not in check:
            dfs(depth+1,item,check|{friend})

for i in range(N+1):
    for item in graph[i]:
        check={i}
        dfs(1,item,check)
print(0)