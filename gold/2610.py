import sys
input=sys.stdin.readline
N=int(input())
M=int(input())
parent=[i for i in range(N+1)]
board=[[float('inf')]*(N+1)for _ in range(N+1)]
for i in range(N+1):
    board[i][i]=0

def find_parent(A):
    if A==parent[A]:
        return A
    else:
        parent[A]=find_parent(parent[A])
        return parent[A]

def union_find(A,B):
    parentA=find_parent(A); parentB=find_parent(B)
    if parentA<parentB:
        parent[parentB]=parentA
    else:
        parent[parentA]=parentB

for _ in range(M):
    A,B=map(int,input().split())
    board[A][B]=1;board[B][A]=1
    union_find(A,B)
for via in range(1,N+1):
    for s in range(1,N+1):
        for e in range(1,N+1):
            if board[s][via]+board[via][e]<board[s][e]:
                board[s][e]=board[s][via]+board[via][e]
party=[[] for _ in range(1+N)]
for i in range(1,N+1):
    party[find_parent(i)].append(i)
answer=[]
for members in party:
    candi=float('inf')
    cnt=float('inf')
    for S in members:
        cur=0
        for E in members:
            if board[S][E]>cur:
                cur=board[S][E]
        if cur<cnt:
            candi=S
            cnt=cur
    if candi!=float('inf'):
        answer.append(candi)
answer=sorted(answer)
print(len(set(answer)))
print(*answer,sep='\n')
