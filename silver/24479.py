import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)
N,M,R=map(int,input().split())

ajdlist=[[]for i in range(N+1)]
check=[0]*(N+1)
count=1
data=[]
for i in range(M):
    a,b=map(int,input().split())
    data.append([a,b])
data.sort(key=lambda x:(x[0],x[1]))
for a,b in data:
    ajdlist[a].append(b)
    ajdlist[b].append(a)

def dfs(v):
    global count
    for i in ajdlist[v]:
        if check[i]==0:
            check[i]=count
            count+=1
            dfs(i)
check[R]=count
count+=1
dfs(R)

for i in range(1,N+1):
    print(check[i])

