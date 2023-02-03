import sys
input=sys.stdin.readline

N=int(input())

edges=[]
for i in range(N+1):
    edges.append([])

for _ in range(N-1):
    i,j=map(int,input().split())
    edges[i].append(j)
    edges[j].append(i)

for i in range(2,N+1):
    print(edges[i][0])
