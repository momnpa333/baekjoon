n,m=map(int,input().split(" "))
graph=[[float('inf')]*(n+1) for _ in range(n+1)]
answer=[[float('inf')]*(n+1) for _ in range(n+1)]
for i in range(1,n+1):
    graph[i][i]=0

for _ in range(m):
    a,b,v=map(int,input().split(" "))
    graph[a][b]=min(graph[a][b],v)
    graph[b][a]=graph[a][b]
    answer[a][b]=b
    answer[b][a]=a

def floyd():
    for via in range(1,n+1):
        for start in range(1,n+1):
            for end in range(1,n+1):
                if graph[start][via]+graph[via][end]<graph[start][end]:
                    graph[start][end]=graph[start][via]+graph[via][end]
                    answer[start][end]=answer[start][via]

# for item in graph:
#     print(item)
floyd()
# for item in graph:
#     print(item)
for i in range(1,n+1):
    for j in range(1,n+1):
        if answer[i][j]!=float('inf'):
            print(answer[i][j],end=' ')
        else:
            print("-",end=' ')
    print()