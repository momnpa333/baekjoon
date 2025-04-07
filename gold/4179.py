import sys
from collections import deque
input=sys.stdin.readline

R,C=map(int,input().split())

board=[list(map(str,input().rstrip())) for _ in range(R)]
check=[[True]*C for _ in range(R)]

fire=[]
j=(-1,-1)
for r in range(R):
    for c in range(C):
        if board[r][c]=='F':
            fire.append((r,c))
        elif board[r][c]=='J':
            j=(r,c)

fire_dq=deque([])

for f in fire:
    fire_dq.append(f)

j_dq=deque([])

j_dq.append((j[0],j[1],0)); check[j[0]][j[1]]=False

if j[0]==R or j[1]==C or j[0]==0 or j[1]==0:
    print(1)
    exit(0)

while j_dq or fire_dq:
    # print(j_dq,fire_dq)
    for _ in range(len(j_dq)):
        jcurr,jcurc,cnt=j_dq.popleft()
        if jcurr==R-1 or jcurc==C-1 or jcurr==0 or jcurc==0:
            if board[jcurr][jcurc]==".":
                print(cnt+1)
                exit(0)
        for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
            JR=jcurr+addr; JC=jcurc+addc
            if 0<=JR<R and 0<=JC<C and board[JR][JC]=='.' and check[JR][JC]==True:
                check[JR][JC]=False
                j_dq.append((JR,JC,cnt+1))
    # print(j_dq,fire_dq)
    for _ in range((len(fire_dq))):
        fcurr,fcurc=fire_dq.popleft()
        for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
            FR=fcurr+addr; FC=fcurc+addc
            if 0<=FR<R and 0<=FC<C and board[FR][FC]!='#'and board[FR][FC]!='F':
                board[FR][FC]='F'
                fire_dq.append((FR,FC))
    # print(j_dq,fire_dq)
# print(board)
print('IMPOSSIBLE')





