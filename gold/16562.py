import sys
input=sys.stdin.readline

N,M,K=map(int,input().split())
money=[0]+list(map(int,input().split()))
parent=[i for i in range(N+1)]

def find_parent(A):
    if parent[A]==A:
        return A
    else:
        parent[A]=find_parent(parent[A])
        return parent[A]

def union_find(A,B):
    parentA=find_parent(A)
    parentB=find_parent(B)

    if money[parentA]<money[parentB]:
        parent[parentB]=parentA
    else:
        parent[parentA]=parentB

for _ in range(M):
    A,B=map(int,input().split())
    union_find(A,B)
parentSet=set()
answer=0
for idx in range(1,N+1):
    parentSet.add(find_parent(idx))

for i in parentSet:
    answer+=money[i]

if answer>K:
    print("Oh no")
else:
    print(answer)

