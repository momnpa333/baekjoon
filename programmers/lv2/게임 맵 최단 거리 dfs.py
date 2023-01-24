maps=[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]

def solution(maps):
    #사방 벽으로 만들기
    newmaps = [[0 for _ in range(len(maps[0])+2)] for _ in range(len(maps)+2)]
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            newmaps[i+1][j+1]=maps[i][j]
    #dfs체크할 배열
    check = [[0 for _ in range(len(maps[0])+2)] for _ in range(len(maps)+2)]
    def dfs(row,col,depth):
        #출구찾음
        if(row==len(maps)and col==len(maps[0])):
            check[row][col]=depth
            return depth
        else:
            check[row][col]=depth
            #안 막혀있고 안 간 곳 조사
            if newmaps[row][col+1]!=0 and check[row][col+1]==0: 
                dfs(row,col+1,depth+1)
            elif newmaps[row+1][col]!=0 and check[row+1][col]==0:
                dfs(row+1,col,depth+1)
            elif newmaps[row][col-1]!=0 and check[row][col-1]==0:
                dfs(row,col-1,depth+1)
            elif newmaps[row-1][col]!=0 and check[row-1][col]==0:
                dfs(row-1,col,depth+1)
    #출구가 막혀있을때
    if newmaps[len(maps)][len(maps[0])+1]==0 and newmaps[len(maps)][len(maps[0])-1]==0 and newmaps[len(maps)+1][len(maps[0])]==0 and newmaps[len(maps)-1][len(maps[0])]==0:
        return -1

    dfs(1,1,1)
    return(check[len(maps)][len(maps[0])])



print(solution(maps))