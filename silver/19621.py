import sys
input=sys.stdin.readline
N=int(input())
S=[]
for i in range(N):
    S.append(list(map(int,input().split())))
S.sort(key=lambda x:(x[0],x[1]))
answer=0
def dfs(start,last,cost):
    global answer
    for i in range(start,len(S)):
        if S[i][0]>=last:
            dfs(i+1,S[i][1],cost+S[i][2])
    if cost>answer:
        answer=cost
dfs(0,0,0)
print(answer)


