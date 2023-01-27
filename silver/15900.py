import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**7)


N=int(input())
grp=[[]for _ in range(N+1)]
check=[0]*(N+1)
for i in range(N-1):
    a,b=map(int,input().split())
    grp[a].append(b)
    grp[b].append(a)
count=0
def search(v,depth):
    childnum=0
    check[v]=1
    for i in grp[v]:
        if check[i]==0: 
            childnum+=1
            search(i,depth+1)
    #leaf nodes
    if childnum==0:
        global count
        count+=depth
        return
    return
search(1,0)
if count%2==0:
    print('No')
else:
    print('Yes')





