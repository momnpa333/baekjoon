import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**7)

N=int(input())

tree=[[]for _ in range(1+N)]
dp=[True]*(1+N);check=[True]*(1+N)
check[1]=False
for _ in range(N-1):
    S,E=map(int,input().split())
    tree[S].append(E); tree[E].append(S)
answer=0
def choice_early(root):
    global answer
    op=False
    for child in tree[root]:
        if check[child]==True:
            check[child]=False
            if choice_early(child)==False:
                op=True
    if op==True:
        answer+=1
    return op
    
choice_early(1)
print(answer)
