import sys
input=sys.stdin.readline
N=int(input())

tree=[set()for _ in range(N+1)]
check=[True]*(N+1)
for _ in range(N-1):
    A,B=map(int,input().split())
    tree[A].add(B); tree[B].add(A)

answer=list(map(int,input().split()))

check[1]=False
cnt=0
def dfs(node):
    global cnt
    cnt+=1;num=0

    while num<len(tree[node]):
        #원하는 경우가 없을때
        if answer[cnt] not in tree[node]:
            #다 안 돌았을 때
            if num<len(tree[node]):
                print(0)
                exit(0)
        #있는데 이미 갔을때
        else:
            if check[answer[cnt]]==False:
                print(0)
                exit(0)
        num+=1
        tree[answer[cnt]].remove(node)
        dfs(answer[cnt])

dfs(1)
print(1)

        

