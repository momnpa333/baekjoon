import sys
input=sys.stdin.readline

N=int(input())

cost=[0]

graph=[[]for _ in range(N+1)]
answer=[-1]*(N+1)

for idx in range(1,N+1):
    inputs=list(map(int,input().split()))
    cost.append(inputs[0])
    for i in inputs[1:len(inputs)-1]:
        graph[idx].append(i)

def find_cost(node):
    if answer[node]!=-1:
        return answer[node]

    ret=cost[node]
    base=0
    for n in graph[node]:
        base=max(find_cost(n),base)
    answer[node]=base+ret
    return answer[node]

for i in range(1,N+1):
    print(find_cost(i))

# print(answer)
