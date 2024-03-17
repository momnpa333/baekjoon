import sys
input=sys.stdin.readline

N,M=map(int,input().split())

Ary=[]
dirAry=[]

rowDir=[0,-1,-1,-1,0,1,1,1]
colDir=[-1,-1,0,1,1,1,0,-1]


for i in range(N):
    Ary.append(list(map(int,input().split())))

for i in range(M):
    dirAry.append(list(map(int,input().split())))


cloudPos=[[N-2,0],[N-2,1],[N-1,0],[N-1,1]]

def moveCloud(type,num):
    global N
    for k in cloudPos:
        k[0]+=rowDir[type-1]*num
        k[1]+=colDir[type-1]*num
        k[0]%=N
        k[1]%=N
def rain(cloudPos):
    global N
    for t in cloudPos:
        Ary[(t[0])%N][(t[1])%N] +=1

def copyWater():
    global N
    for k in cloudPos:
        for j in range(1,8,2):
            checkR=k[0]+rowDir[j]
            checkC=k[1]+colDir[j]
            if 0<=checkR<N and 0<=checkC<N:
                if Ary[checkR][checkC]>=1:
                    Ary[k[0]][k[1]]+=1

def delWater():
    global N
    alreadyCloud=set()
    for i in cloudPos:
        alreadyCloud.add((i[0],i[1]))
    newcloudPos=[]
    for i in range(N):
        for j in range(N):
            if (i,j) not in alreadyCloud:
                if Ary[i][j]>=2:
                    Ary[i][j]-=2
                    newcloudPos.append([i,j])
    return newcloudPos

for dir in dirAry:
    moveCloud(dir[0],dir[1])
    rain(cloudPos)
    copyWater()
    cloudPos=delWater()

solve=0
for i in Ary:
    solve+=sum(i)
print(solve)






