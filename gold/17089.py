import sys
input=sys.stdin.readline
N,M=map(int,input().split())

graph=[set()for _ in range(N+1)]; friendSet=set()

for _ in range(M):
    A,B=map(int,input().split())
    for friend in graph[A]:
        if friend in graph[B]:
            friendSet.add((A,B,friend))
    graph[A].add(B); graph[B].add(A)
answer=float('inf')
for item in friendSet:
    A,B,C=item
    answer=min(answer,len(graph[A])-2+len(graph[B])-2+len(graph[C])-2)
if answer==float('inf'):
    print(-1)
else:
    print(answer)