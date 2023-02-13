import sys
from collections import deque

input=sys.stdin.readline

A,B=map(int,input().split())

N,M=map(int,input().split())

robot=[[]for _ in range(N+1)]
cmds=[]
dir={}
dir['W']=[-1,0];dir['E']=[1,0];dir['N']=[0,1];dir['S']=[0,-1]

for i in range(N):
    x,y,dirtmp=input().strip().split()
    robot[i+1]=[int(x),int(y),dirtmp]
for i in range(M):
    num,opt,cycle=input().strip().split()
    cmds.append([int(num),opt,int(cycle)])

flag=0
for cmd in cmds:
    if cmd[1]=='L':
        for i in range(cmd[2]):
            if robot[cmd[0]][2]=='N':
                robot[cmd[0]][2]='W'
            elif robot[cmd[0]][2]=='W':
                robot[cmd[0]][2]='S'
            elif robot[cmd[0]][2]=='S':
                robot[cmd[0]][2]='E'
            else:
                robot[cmd[0]][2]='N'
    elif cmd[1]=='R':
        for i in range(cmd[2]):
            if robot[cmd[0]][2]=='N':
                robot[cmd[0]][2]='E'
            elif robot[cmd[0]][2]=='E':
                robot[cmd[0]][2]='S'
            elif robot[cmd[0]][2]=='S':
                robot[cmd[0]][2]='W'
            else:
                robot[cmd[0]][2]='N'
    elif cmd[1]=='F':
        for i in range(cmd[2]):
            robot[cmd[0]][0]+=dir[robot[cmd[0]][2]][0]
            robot[cmd[0]][1]+=dir[robot[cmd[0]][2]][1]
            #벽을 뚫었을때
            if robot[cmd[0]][0]<=0 or robot[cmd[0]][0]>A or robot[cmd[0]][1]<=0 or robot[cmd[0]][1]>B:
                print("Robot",cmd[0],"crashes into the wall")
                flag=1
                break
            #기계 충돌
            for i in range(1,len(robot)):
                if robot[i][0]==robot[cmd[0]][0] and robot[i][1]==robot[cmd[0]][1] and i!=cmd[0]:
                    print("Robot",cmd[0],"crashes into robot",i)
                    flag=1
                    break
            if flag==1:
                break
    if flag==1:
        break
else:
    print("OK")



