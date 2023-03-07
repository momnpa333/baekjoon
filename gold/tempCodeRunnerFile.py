import sys
sys.setrecursionlimit(10**6)

R,C=map(int,input().split())

maze=[list(map(str,input().strip()))for _ in range(R)]

dic={"D":[1,0],"L":[0,-1],"R":[0,1],"U":[-1,0]}


def dfs(r,c,cmd):
    maze[r][c]=1
    if 0<=r+cmd[0]<R and 0<=c+cmd[1]<C and maze[r+cmd[0]][c+cmd[1]]!=1:
        dfs(r+cmd[0],c+cmd[1],dic[maze[r+cmd[0]][c+cmd[1]]])
cnt=0
for i in range(R):
    for j in range(C):
        if maze[i][j]!=1:
            cnt+=1
            dfs(i,j,dic[maze[i][j]])
print(cnt)

