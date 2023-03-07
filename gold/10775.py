import sys
input=sys.stdin.readline

G=int(input())
P=int(input())
gate=[i for i in range(G+1)]
cnt=0
flag=1
def dfs(v):
    global cnt
    global flag
    if gate[v]==0:
        return 0
    if v!=0 and gate[v]==v:
        gate[v]-=1
        cnt+=1
        flag=2
        return gate[v]
    gate[v]=dfs(gate[v])
    return gate[v]

park=[]
for i in range(P):
    p=int(input())
    park.append(p)
for p in park:
    dfs(p)
    if flag==1:
        answer=cnt
        break
    flag=1
print(cnt)


    