import sys
sys.setrecursionlimit(10**6)

R,C=map(int,input().split())

maze=[list(map(str,input().strip()))for _ in range(R)]

dic={"D":[1,0],"L":[0,-1],"R":[0,1],"U":[-1,0]}

cnt=0

def dfs(r,c):
    global cnt
    if type(maze[r][c])==int:
        return maze[r][c]
    cmd=dic[maze[r][c]]
    r1=r+cmd[0]
    c1=c+cmd[1]
    if r1==-1 or c1==-1 or r1==R or c1==C:
        cnt+=1
        maze[r][c]=cnt
        return cnt
    if 0<=r1<R and 0<=c1<C:
        if (r1,c1) in check:
            cnt+=1
            maze[r][c]=cnt
            return maze[r][c]
        check.add((r1,c1))
        maze[r][c]=dfs(r1,c1)
        return maze[r][c]
    
for i in range(R):
    for j in range(C):
        if maze[i][j]!=1:
            check=set()
            check.add((i,j))
            dfs(i,j)
print(cnt)

