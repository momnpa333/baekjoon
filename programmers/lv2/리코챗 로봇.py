from collections import deque

def solution(board):
    R=len(board)
    C=len(board[0])
    maps=[]
    for i in range(R):
        maps.append([-1]*C)
    distinct=set()
    
    for i in range(R):
        for j in range(C):
            if board[i][j]=='D':
                distinct.add((i,j))
            if board[i][j]=='G':
                goal=(i,j)
            if board[i][j]=="R":
                start=(i,j)
    
    #dir
    dr=[0,1,0,-1]
    dc=[1,0,-1,0]
    #bfs
    cnt=0
    dq=deque([])
    dq.append(start)
    maps[start[0]][start[1]]=cnt
    while dq:
        cnt+=1
        T=len(dq)
        while T>0:
            T-=1
            tr,tc=dq.popleft()
            for i in range(4):
                r=tr+dr[i]; c=tc+dc[i]
                while True:
                    if r<0 or r>=R or c<0 or c>=C or (r,c)in distinct:
                        r-=dr[i]; c-=dc[i]
                        break
                    r+=dr[i]; c+=dc[i]
                if maps[r][c]==-1:
                   dq.append((r,c))
                   maps[r][c]=cnt
    
    return maps[goal[0]][goal[1]]
board=["...D..R", ".D.G...", "....D.D", "D....D.", "..D...."]	
solution(board)