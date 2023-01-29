import sys
input=sys.stdin.readline

N,M=map(int,input().split())

tetris = [list(map(int,input().split()))for _ in range(N)]

one=[[[0,0],[0,1],[0,2],[0,3]],[[0,0],[1,0],[2,0],[3,0]]]
nemo=[[[0,0],[0,1],[1,0],[1,1]]]
nieun=[[[0,0],[1,0],[1,1],[1,2]],[[0,0],[0,1],[1,0],[2,0]],[[0,0],[0,1],[0,2],[1,2]],[[0,1],[1,1],[2,1],[2,0]],
    [[1,0],[1,1],[1,2],[0,2]],[[0,0],[1,0],[2,0],[2,1]],[[0,0],[0,1],[0,2],[1,0]],[[0,0],[0,1],[1,1],[2,1]]]
gdan=[[[0,0],[1,0],[1,1],[2,1]],[[0,1],[0,2],[1,0],[1,1]],[[0,1],[1,1],[1,0],[2,0]],[[0,0],[0,1],[1,1],[1,2]]]
t=[[[0,1],[1,0],[1,1],[1,2]],[[0,0],[1,0],[2,0],[1,1]],[[0,0],[0,1],[0,2],[1,1]],[[0,1],[1,0],[1,1],[2,1]]]
blocks=[]
blocks.append(one)
blocks.append(nemo)
blocks.append(nieun)
blocks.append(gdan)
blocks.append(t)
sumAry=[]
sum=0
for row in range(N):
    for col in range(M):
        for block in blocks:
            for dir in block:
                for i in dir:
                    if row+i[0]>=N or col+i[1]>=M:
                        sum+=-99999
                    else:
                        sum+=tetris[row+i[0]][col+i[1]]
                else:
                    sumAry.append(sum)
                    sum=0

                    
print(max(sumAry))



