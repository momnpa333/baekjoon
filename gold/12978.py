import sys
sys.setrecursionlimit(10**7)
input=sys.stdin.readline
N=int(input())
graph=[[]for _ in range(1+N)]
for _ in range(N-1):
    S,E=map(int,input().split())
    graph[S].append(E); graph[E].append(S)
check=[True]*(1+N)
check[1]=False;answer=0

def build_police(root):
    global answer
    op=False
    for child in graph[root]:
        if check[child]==False:
            continue
        check[child]=False
        if build_police(child)==False:
            op=True
    if op==True:
        answer+=1
    return op
build_police(1)
print(answer)



