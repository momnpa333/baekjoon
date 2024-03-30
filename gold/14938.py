N,M,R=map(int,input().split(' '))

graph=[[float('inf')]*(N+1) for _ in range(N+1)]

items=[0]+list(map(int,input().split(' ')))

for i in range(N):
    graph[i+1][i+1] =0

for _ in range(R):
    A,B,V=map(int,input().split(' '))
    graph[A][B]=V
    graph[B][A]=V

def floyd():
    for via in range(1,N+1):
        for start in range(1,N+1):
            for end in range(1,N+1):
                graph[start][end]=min(graph[start][via]+graph[via][end],graph[start][end])
                graph[end][start]=graph[start][end]

def get_score(start_node,M):
    ret=0
    # print(items)
    for idx,dist in enumerate(graph[start_node]):
        # print(M,dist,idx,items[idx])
        if M>=dist:
            ret+=items[idx]
    return ret

answer=0
floyd()

for i in range(1,N+1):
    # print(get_score(i,M))
    answer=max(get_score(i,M),answer)
# print(items)
# print(*graph,sep='\n')
print(answer)

