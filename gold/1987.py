R,C=map(int,input().split())
maze=[]
for _ in range(R):
     maze.append(list(input()))
dix = [-1, 1, 0, 0]
diy = [0, 0, -1, 1]
answer=0
check=set(maze[0][0])
def dfs(row,col,depth):
    global answer
    answer=max(answer,depth)
    for i in range(4):
        dx=row+dix[i]
        dy=col+diy[i]
        if 0<=dx<R and 0<=dy<C and not maze[dx][dy] in check:
                check.add(maze[dx][dy])
                dfs(dx,dy,depth+1)
                check.remove(maze[dx][dy])
dfs(0,0,1)
print(answer)

