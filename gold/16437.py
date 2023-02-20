import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)


N=int(input())
node=[['X',0,0],['S',0,0]]
adjlist=[[]for _ in range(N+1)]
for i in range(2,N+1):
    t,a,p=input().split()
    node.append([t,int(a),int(p)])
    adjlist[i].append(int(p))
    adjlist[int(p)].append(i)

check=[0]*(N+1)

def dfs(v):
    check[v]=1
    totalsheep=0
    for i in adjlist[v]:
        if check[i]==0:
            totalsheep+=dfs(i)
    if node[v][0]=='S':
        return node[v][1]+totalsheep
    elif node[v][0]=='W':
        if totalsheep-node[v][1]>0:
            return totalsheep-node[v][1]
        else:
            return 0
print(dfs(1))