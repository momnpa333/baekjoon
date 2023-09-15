import sys
from collections import deque
input=sys.stdin.readline

N,M=map(int,input().split())

A1=list(map(int,input().split()))
A2=list(map(int,input().split()))
B1=list(map(int,input().split()))
B2=list(map(int,input().split()))
solve1=0
solve2=0


dir=[(0,1),(1,0),(0,-1),(-1,0)]
check=[[0]*(M+1) for _ in range(N+1)]
save=[]
dq=deque([])
dq.append(A1)

def findA1(r,c,cnt):
    save.append([r,c])
    if [r,c]==A1:
        return cnt
    else:
        return findA1(check[r][c][0],check[r][c][1],cnt+1)
    
def findB1(r,c,cnt):
    save.append([r,c])
    if [r,c]==B1:
        return cnt
    else:
        return findB1(check[r][c][0],check[r][c][1],cnt+1)
    

while dq:
    T=len(dq)
    while T>0:
        T-=1
        tmp=dq.popleft()
        for i in dir:
            x=tmp[0]+i[0]
            y=tmp[1]+i[1]
            if 0<=x<=N and 0<=y<=M and [x,y]!=B1 and [x,y]!=B2:
                if [x,y]==A2:
                    check[x][y]=tmp
                    break
                if check[x][y]==0:
                    check[x][y]=tmp
                    dq.append([x,y])
        if check[A2[0]][A2[1]]!=0:
            break
    if check[A2[0]][A2[1]]!=0:
                break
                
solve1+=findA1(A2[0],A2[1],0)

check=[[0]*(M+1) for _ in range(N+1)]
for i in save:
    check[i[0]][i[1]]=1
    
dq=deque([])
dq.append(B1)

while dq:
    T=len(dq)
    while T>0:
        T-=1
        tmp=dq.popleft()
        for i in dir:
            x=tmp[0]+i[0]
            y=tmp[1]+i[1]
            if 0<=x<=N and 0<=y<=M and [x,y]!=A1 and [x,y]!=A2:
                if [x,y]==B2:
                    check[x][y]=tmp
                    break
                if check[x][y]==0:
                    check[x][y]=tmp
                    dq.append([x,y])
        if check[B2[0]][B2[1]]!=0:
            break
    if check[B2[0]][B2[1]]!=0:
                break
    
if(check[B2[0]][B2[1]]==0):
    solve1=987654321
else:
    solve1+=findB1(B2[0],B2[1],0)

##########################################3

dq=deque([])
dq.append(B1)
save=[]
check=[[0]*(M+1) for _ in range(N+1)]
while dq:
    T=len(dq)
    while T>0:
            T-=1
            tmp=dq.popleft()
            for i in dir:
                x=tmp[0]+i[0]
                y=tmp[1]+i[1]
                if 0<=x<=N and 0<=y<=M and [x,y]!=A1 and [x,y]!=A2:
                    if [x,y]==B2:
                        check[x][y]=tmp
                        break
                    if check[x][y]==0:
                        check[x][y]=tmp
                        dq.append([x,y])
            if check[B2[0]][B2[1]]!=0:
                break
    if check[B2[0]][B2[1]]!=0:
        break
    
solve2+=findB1(B2[0],B2[1],0)
        
check=[[0]*(M+1) for _ in range(N+1)]
for i in save:
        check[i[0]][i[1]]=1
    
dq=deque([])
dq.append(A1)
while dq:
        T=len(dq)
        while T>0:
            T-=1
            tmp=dq.popleft()
            for i in dir:
                x=tmp[0]+i[0]
                y=tmp[1]+i[1]
                if 0<=x<=N and 0<=y<=M and [x,y]!=B1 and [x,y]!=B2:
                    if [x,y]==A2:
                        check[x][y]=tmp
                        break
                    if check[x][y]==0:
                        check[x][y]=tmp
                        dq.append([x,y])
            if check[A2[0]][A2[1]]!=0:
                break
        if check[A2[0]][A2[1]]!=0:
                    break
        
if(check[A2[0]][A2[1]]==0):
    solve2=987654321
else:
    solve2+=findA1(A2[0],A2[1],0)


if solve2==solve1==987654321:
    print("IMPOSSIBLE")
else:
    if solve2>solve1:
        print(solve1)
    else:
        print(solve2)     

