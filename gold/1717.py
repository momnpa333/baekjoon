import sys
sys.setrecursionlimit(10**8)
input=sys.stdin.readline

N,M=map(int,input().split(' '))

commands=[list(map(int,input().split(' '))) for _ in range(M)]
# print(commands)

parents=[0]*(N+1)

for i in range(N+1):
    parents[i] = i

def find_parent(node):
    if node==parents[node]:
        return node
    parents[node]=find_parent(parents[node])
    return parents[node]

def union_node(a,b):
    A=find_parent(a)
    B=find_parent(b)

    if A<B:
        parents[B]=A
    else:
        parents[A]=B

for command in commands:
    op,a,b=command
    if op==0:
        union_node(a,b)
    if op==1:
        if find_parent(a)==find_parent(b):
            print("YES")
        else:
            print("NO")
