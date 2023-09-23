    for i in range(4):
            dir=(dir+i)%4
            nextR=r+DirAry[dir][0]
            nextC=c+DirAry[dir][1]
            if board[nextR][nextC]==0:
                r=nextR
                c=nextC
                break