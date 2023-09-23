import sys
input=sys.stdin.readline

N=int(input())
likeAry=[]
likeset=dict()
for i in range(N**2):
    likeAry.append(list(map(int,input().split())))
    likeset[likeAry[i][0]]=likeAry[i][1:]
dir=[(0,1),(1,0),(0,-1),(-1,0)]

seatAry=[]
for i in range(N+1):
    seatAry.append([0]*(N+1))

for i in range(N+1):
    seatAry[0][i]=seatAry[i][0]=-1


seatEmptyAry=[]
for i in range(N+1):
    seatEmptyAry.append([0]*(N+1))


seatLikeAry=[]
for i in range(N+1):
    seatLikeAry.append([0]*(N+1))


def howManyEmpty():
    empty=0
    for i in range(1,N+1):
        for j in range(1,N+1):
            if seatAry[i][j]==0:
                for k in dir:
                    if 0<i+k[0]<N+1 and 0<j+k[1]<N+1:
                        if seatAry[i+k[0]][j+k[1]]==0:
                            empty+=1
                seatEmptyAry[i][j]=empty
                empty=0

def returnEmptySeat():
    maxEmpty=0
    maxEmptySeat=[]
    for i in range(1,N+1):
        for j in range(1,N+1):
            if seatAry[i][j]==0:
                if seatEmptyAry[i][j]>maxEmpty:
                    maxEmpty=seatEmptyAry[i][j]
                    maxEmptySeat=[]
                    maxEmptySeat.append((i,j))
                elif seatEmptyAry[i][j]==maxEmpty:
                    maxEmptySeat.append((i,j))
    return maxEmptySeat

def howManyLike(likes):
    for i in range(1,N+1):
        for j in range(1,N+1):
            if seatAry[i][j]==0:
                for k in dir:
                    if 0<i+k[0]<N+1 and 0<j+k[1]<N+1:
                        if seatAry[i+k[0]][j+k[1]] in likes:
                            seatLikeAry[i][j]+=1

def returnLikeSeat():
    maxLike=0
    maxLikeSeat=[]
    for i in range(1,N+1):
        for j in range(1,N+1):
            
            if seatAry[i][j]==0:
                if seatLikeAry[i][j]>maxLike:
                    maxLike=seatLikeAry[i][j]
                    maxLikeSeat=[]
                    maxLikeSeat.append((i,j))
                elif seatLikeAry[i][j]==maxLike:
                    maxLikeSeat.append((i,j))
    return maxLikeSeat

def Happy():
    happy=0
    ret=0
    for i in range(1,N+1):
        for j in range(1,N+1):
            for k in dir:
                if 0<i+k[0]<N+1 and 0<j+k[1]<N+1:
                    if seatAry[i+k[0]][j+k[1]] in likeset[seatAry[i][j]]:
                        happy+=1
            ret+=int(10**(happy-1))
            happy=0
                
    return ret

con12Ary=[]
for i in range(N**2):
    #1
    howManyLike(likeAry[i][1:])
    LSAry=returnLikeSeat()

    #print(LSAry)
    #2
    howManyEmpty()
    for k in LSAry:
        con12Ary.append((k[0],k[1],seatEmptyAry[k[0]][k[1]]))
    
    con12Ary = sorted(con12Ary, key=lambda x: (-x[2], x[0], x[1]))
    #print(con12Ary,likeAry[i][0])
    
    seatAry[con12Ary[0][0]][con12Ary[0][1]]=likeAry[i][0]
    #print(seatAry)
    
    #print(con12Ary)
    seatEmptyAry=[]
    for i in range(N+1):
        seatEmptyAry.append([0]*(N+1))


    seatLikeAry=[]
    for i in range(N+1):
        seatLikeAry.append([0]*(N+1))
    
    con12Ary=[]
    #print(seatAry)

print(Happy())





