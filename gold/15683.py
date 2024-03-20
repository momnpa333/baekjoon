from collections import deque
import copy

N,M=map(int,(input().split(' ')))

answer=987654321
room=[list(map(int,input().split(' '))) for _ in range(N)]

# print(room)

def score(room):
    cnt=0
    for r in room:
        for item in r:
            if item==0:
                cnt+=1
    return cnt

def watch(depth,lev,r,c,room):
    global answer
    if depth==len(cctvs)-1:
        S=score(room)
        if S<answer:
            answer=S
        return 

    if lev==1:
        for dirr,dirc in ((0,1),(1,0),(0,-1),(-1,0)):
            copyroom=copy.deepcopy(room)
            curr=r;curc=c
            while True:
                curr+=dirr;curc+=dirc
                if 0<=curr<len(room) and 0<=curc<len(room[0]) and room[curr][curc]!=6:
                    if room[curr][curc]==0:
                        copyroom[curr][curc]='#'
                else:
                    break
            watch(depth+1,cctvs[depth+1][0],cctvs[depth+1][1],cctvs[depth+1][2],copyroom)
    if lev==2:
        for dirs in (((0,1),(0,-1)),((-1,0),(1,0))):
            copyroom=copy.deepcopy(room)
            for dirr,dirc in dirs:
                curr=r;curc=c
                while True:
                    curr+=dirr;curc+=dirc
                    if 0<=curr<len(room) and 0<=curc<len(room[0]) and room[curr][curc]!=6:
                        if room[curr][curc]==0:
                            copyroom[curr][curc]='#'
                    else:
                        break
            watch(depth+1,cctvs[depth+1][0],cctvs[depth+1][1],cctvs[depth+1][2],copyroom)
    if lev==3:
        for dirs in (((0,-1),(-1,0)),((0,-1),(1,0)),((1,0),(0,1)),((0,1),(-1,0))):
            copyroom=copy.deepcopy(room)
            for dirr,dirc in dirs:
                curr=r;curc=c
                while True:
                    curr+=dirr;curc+=dirc
                    if 0<=curr<len(room) and 0<=curc<len(room[0]) and room[curr][curc]!=6:
                        if room[curr][curc]==0:
                            copyroom[curr][curc]='#'
                    else:
                        break
            watch(depth+1,cctvs[depth+1][0],cctvs[depth+1][1],cctvs[depth+1][2],copyroom)
    if lev==4:
        for dirs in (((0,1),(-1,0),(0,-1)),((0,1),(1,0),(-1,0)),((1,0),(0,-1),(0,1)),((0,-1),(1,0),(-1,0))):
            copyroom=copy.deepcopy(room)
            for dirr,dirc in dirs:
                curr=r;curc=c
                while True:
                    curr+=dirr;curc+=dirc
                    if 0<=curr<len(room) and 0<=curc<len(room[0]) and room[curr][curc]!=6:
                        if room[curr][curc]==0:
                            copyroom[curr][curc]='#'
                    else:
                        break
            watch(depth+1,cctvs[depth+1][0],cctvs[depth+1][1],cctvs[depth+1][2],copyroom)
    if lev==5:
        copyroom=copy.deepcopy(room)
        for dirr,dirc in ((0,1),(1,0),(0,-1),(-1,0)):
            curr=r;curc=c
            while True:
                curr+=dirr;curc+=dirc
                if 0<=curr<len(room) and 0<=curc<len(room[0]) and room[curr][curc]!=6:
                    if room[curr][curc]==0:
                        copyroom[curr][curc]='#'
                else:
                    break
        watch(depth+1,cctvs[depth+1][0],cctvs[depth+1][1],cctvs[depth+1][2],copyroom)
    pass


cctvs=[]
for r in range(N):
    for c in range(M):
        if room[r][c]!=0 and room[r][c]!=6:
            cctvs.append((room[r][c],r,c))
cctvs.append([-1,-1,-1])

watch(0,cctvs[0][0],cctvs[0][1],cctvs[0][2],room)
print(answer)

