import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**7)

R,C=map(int,input().split())
answer=[]
board=[]
for i in range(R):
    board.append(list(map(str,input().strip())))

dir=[[0,1],[1,0],[0,-1],[-1,0]]
def dfs(row,col,check,depth,copyboard1):
    if (board[row][col] in check) or (row==R-1 and col==C-1):
        answer.append(depth)
        return
    check.append(board[row][col])   
    copyboard1[row][col]="-1"
    for r,c in dir:         
        if 0<=(row+r)<R and 0<=(col+c)<C and copyboard1[row+r][col+c]!="-1":
            tmp=check.copy()
            copyboard2=copyboard1.copy()
            dfs(row+r,col+c,tmp,depth+1,copyboard2)
copyboard=board.copy()
dfs(0,0,[],0,copyboard)
print(answer)

