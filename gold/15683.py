import sys
input = sys.stdin.readline

N,M=map(int,input().split())

office=[]

cctv1=[0]
cctv2=[0,2]
cctv3=[0,3]
cctv4=[0,2,3]
cctv5=[0,1,2,3]

dir=[(0,1),(1,0),(0,-1),(-1,0)]

for i in range(N):
    office.append(list(map(int,input().split())))
#print(office)

def turn90(cctv):
    for i in range(len(cctv)):
        cctv[i] = (cctv[i]+1)%4

def view(r,c,cctv,copy):
    for cctvType in cctv:
        for i in range(4):
            curPosR=r
            curPosC=c

            cctvType=(cctvType+i)%4
            while True:
                curPosR+=dir[cctvType][0]
                curPosC+=dir[cctvType][1]

                if 0<=curPosR<N and 0<=curPosC<M and copy[curPosR][curPosC] != 6:
                    if copy[curPosR][curPosC] == 0:
                        copy[curPosR][curPosC] = '#'
                else:
                    break
view(2,2,cctv2,office)
print(office)

            

