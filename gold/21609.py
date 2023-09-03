N,M=map(int,input().split())

dir=[(0,1),(1,0),(0,-1),(-1,0)]
answer=0
#make matrix
matrix=[]
for _ in range(N):
    matrix.append(list(map(int,input().split())))

def makeBlock(r,c,key,mem,block):
    for i in range(4):
        nr=r+dir[i][0]
        nc=c+dir[i][1]
        if (nr,nc) not in mem and 0<=nr<N and 0<=nc<N:
            if matrix[nr][nc]==key or matrix[nr][nc]==0:
                mem.add((nr,nc))
                block.append((nr,nc))
                makeBlock(nr,nc,key,mem,block)


def findBlock():
    targetBlock=[]
    targetScore=0
    for i in range(N-1,-1,-1):
        for j in range(N-1,-1,-1):
            cache=set()
            block=[]
            score=0
            if matrix[i][j]!=-1 and matrix[i][j]!='.' and matrix[i][j]!=0:
                cache.add((i,j))
                block.append((i,j))
                makeBlock(i,j,matrix[i][j],cache,block)
                for di in block:
                    if matrix[di[0]][di[1]]==0:
                        score+=1
            targetBlock.sort(key=lambda x:(x[0],x[1]))
            block.sort(key=lambda x:(x[0],x[1]))
            if len(targetBlock)<len(block):
                targetBlock=block
                targetScore=score
            elif len(targetBlock)==len(block):
                if targetScore<score:
                    targetBlock=block
                    targetScore=score
                elif targetScore==score and targetBlock!=[]:
                    delRainbow(targetBlock)
                    delRainbow(block)
                    if targetBlock[0][0]<block[0][0]:
                        targetBlock=block
                        targetScore=score
                    elif targetBlock[0][0]==block[0][0]:
                        if targetBlock[0][1]<block[0][1]:
                            targetBlock=block
                            targetScore=score
    return targetBlock

def removeBlock(block):
    global answer
    for i in range(N):
        for j in range(N):
            if (i,j) in block:
                matrix[i][j]='.'
    answer+=len(block)**2

def delRainbow(mat):
    while True:
        if matrix[mat[0][0]][mat[0][1]]==0:
            mat.append(mat.pop(0))
        else: break


def rotateBlock():
    return list(reversed(list(map(list, zip(*matrix)))))

def gravity():
    for i in range(N):
        for j in range(N):
            if matrix[i][j]=='.':
                for k in range(i-1,-1,-1):
                    if matrix[k][j]!=-1 and matrix[k][j]!='.':
                        matrix[k+1][j],matrix[k][j]=matrix[k][j],matrix[k+1][j]
                    else:
                        break

while True:
    block=findBlock()
    if len(block)>1:
        removeBlock(block)
    else:
        break       
    gravity()
    matrix=rotateBlock()
    gravity()
    if block==[]:
        break
print(answer)
