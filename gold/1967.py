import sys

sys.setrecursionlimit(10**7)
input = sys.stdin.readline

N=int(input())
node=[]
for i in range(N+1):
    node.append([])
for i in range(N-1):
    p,c,item=map(int,input().split())
    node[p].append([c,item])
    node[c].append([p,item])

nodeLengthList=[0]*(N+1)
check=[False]*(N+1)
def dfs(child,nodeLength):
    check[child]=True
    nodeLengthList[child]=nodeLength
    
    for i in node[child]:
        if not check[i[0]]:
            dfs(i[0],nodeLength+i[1])
dfs(1,0)
first=(nodeLengthList.index(max(nodeLengthList)))
#print(nodeLengthList)
nodeLengthList=[0]*(N+1)

check=[False]*(N+1)
second=(nodeLengthList.index(max(nodeLengthList)))
dfs(first,0)
#print(nodeLengthList)

print(max(nodeLengthList))