from collections import deque
import heapq
import sys
input=sys.stdin.readline
NC,NR=map(int,input().split())

board=[list(map(str,input().rstrip())) for _ in range(NR)]
check=[[[[float('inf')]*4,float('inf')]for _ in range(NC)] for _ in range(NR)] #거리, 거울 개수
visit=[[True for _ in range(NC)] for _ in range(NR)] 

dot=[]
for r in range(NR):
    for c in range(NC):
        if board[r][c]=='C':
            dot.append((r,c))

# dq=deque([])
pq=[]
check[dot[0][0]][dot[0][1]][0][0]=0;check[dot[0][0]][dot[0][1]][0][1]=0;check[dot[0][0]][dot[0][1]][0][2]=0;check[dot[0][0]][dot[0][1]][0][3]=0

for idx,add in enumerate(((0,1),(1,0),(0,-1),(-1,0))):
    addr,addc=add
    R=dot[0][0]+addr;C=dot[0][1]+addc
    if 0<=R<NR and 0<=C<NC and board[R][C]!="*":
        heapq.heappush(pq,(0,R,C,1,idx))
        check[R][C][0][idx]=1
        check[R][C][1]=0
# print(visit)
while pq:
        print(pq)
        cnt,r,c,v,prev=heapq.heappop(pq)
        
        # print(visit)
        for idx,add in enumerate(((0,1),(1,0),(0,-1),(-1,0))):
            if (prev+2)%4==idx:
                continue
            addr,addc=add
            R=r+addr;C=c+addc
            if 0<=R<NR and 0<=C<NC and board[R][C]!="*":
                visit[R][C]=False
                if prev!=idx:
                    if cnt+1<check[R][C][1]:
                        check[R][C][1]=cnt+1
                        if board[R][C]!="C":
                            heapq.heappush(pq,(cnt+1,R,C,v+1,idx))
                else:
                    if cnt<=check[R][C][1]:
                        check[R][C][1]=cnt
                        if board[R][C]!="C":
                            heapq.heappush(pq,(cnt,R,C,v+1,idx))

# print(check[8][1][1])

print(check[dot[1][0]][dot[1][1]][1])

# 15       9
# ...*...***.C..*
# .*.*.*........*
# .*...*...*....*
# .*.*....****.**
# .*..**........*
# .**..********.*
# .*...*...*..*.*
# .**..***.*.**.*
# C........*.....
# ..***..........