from collections import deque
import copy
N,M=map(int,input().split(' '))

board=[list(map(str,input()))for i in range(N)]

redR=0;redC=0;blueR=0;blueC=0;goleR=0;goleC=0
for r in range(N):
    for c in range(M):
        if board[r][c]=="R":
            redR=r; redC=c
        if board[r][c]=="B":
            blueR=r; blueC=c
        if board[r][c]=="O":
            goleR=r; goleC=c

def moveball(addr,addc,R,C,board):
    curr=R; curc=C
    while True:
        if 0<=curr+addr<len(board) and 0<=curc+addc<len(board[0]):
            if board[curr+addr][curc+addc]==".":
                curr+=addr; curc+=addc
            elif board[curr+addr][curc+addc]=="O":
                return curr+addr, curc+addc
            else:
                return curr,curc
        else:
            return curr,curc


dq=deque([])
dq.append([0,redR,redC,blueR,blueC,board])
check=set()

while dq:
    for _ in range(len(dq)):
        depth,redR,redC,blueR,blueC,b=dq.popleft()
        check.add((redR,redC,blueR,blueC))
        # print(depth)
        for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
            if (addr,addc)==(0,1):
                if redC>blueC:
                    tredR,tredC=moveball(addr,addc,redR,redC,b)
                    b[redR][redC]='.'
                    b[tredR][tredC]='R'
                    if tredR==goleR and tredC==goleC:
                        b[tredR][tredC]='O'
                    tblueR,tblueC=moveball(addr,addc,blueR,blueC,b)
                    b[blueR][blueC]='.'
                    b[tblueR][tblueC]='B'
                    if tblueR==goleR and tblueC==goleC:
                        b[tblueR][tblueC]='O'
                else:
                    tblueR,tblueC=moveball(addr,addc,blueR,blueC,b)
                    b[blueR][blueC]='.'
                    b[tblueR][tblueC]='B'
                    if tblueR==goleR and tblueC==goleC:
                        b[tblueR][tblueC]='O'
                    tredR,tredC=moveball(addr,addc,redR,redC,b)
                    b[redR][redC]='.'
                    b[tredR][tredC]='R'
                    if tredR==goleR and tredC==goleC:
                        b[tredR][tredC]='O'
            if (addr,addc)==(1,0):
                if redR>blueR:
                    tredR,tredC=moveball(addr,addc,redR,redC,b)
                    b[redR][redC]='.'
                    b[tredR][tredC]='R'
                    if tredR==goleR and tredC==goleC:
                        b[tredR][tredC]='O'
                    tblueR,tblueC=moveball(addr,addc,blueR,blueC,b)
                    b[blueR][blueC]='.'
                    b[tblueR][tblueC]='B'
                    if tblueR==goleR and tblueC==goleC:
                        b[tblueR][tblueC]='O'
                else:
                    tblueR,tblueC=moveball(addr,addc,blueR,blueC,b)
                    b[blueR][blueC]='.'
                    b[tblueR][tblueC]='B'
                    if tblueR==goleR and tblueC==goleC:
                        b[tblueR][tblueC]='O'
                    tredR,tredC=moveball(addr,addc,redR,redC,b)
                    b[redR][redC]='.'
                    b[tredR][tredC]='R'
                    if tredR==goleR and tredC==goleC:
                        b[tredR][tredC]='O'
            if (addr,addc)==(0,-1):
                if redC<blueC:
                    tredR,tredC=moveball(addr,addc,redR,redC,b)
                    b[redR][redC]='.'
                    b[tredR][tredC]='R'
                    if tredR==goleR and tredC==goleC:
                        b[tredR][tredC]='O'
                    tblueR,tblueC=moveball(addr,addc,blueR,blueC,b)
                    b[blueR][blueC]='.'
                    b[tblueR][tblueC]='B'
                    if tblueR==goleR and tblueC==goleC:
                        b[tblueR][tblueC]='O'
                else:
                    tblueR,tblueC=moveball(addr,addc,blueR,blueC,b)
                    b[blueR][blueC]='.'
                    b[tblueR][tblueC]='B'
                    if tblueR==goleR and tblueC==goleC:
                        b[tblueR][tblueC]='O'
                    tredR,tredC=moveball(addr,addc,redR,redC,b)
                    b[redR][redC]='.'
                    b[tredR][tredC]='R'
                    if tredR==goleR and tredC==goleC:
                        b[tredR][tredC]='O'
            if (addr,addc)==(-1,0):
                if redR<blueR:
                    tredR,tredC=moveball(addr,addc,redR,redC,b)
                    b[redR][redC]='.'
                    b[tredR][tredC]='R'
                    if tredR==goleR and tredC==goleC:
                        b[tredR][tredC]='O'
                    tblueR,tblueC=moveball(addr,addc,blueR,blueC,b)
                    b[blueR][blueC]='.'
                    b[tblueR][tblueC]='B'
                    if tblueR==goleR and tblueC==goleC:
                        b[tblueR][tblueC]='O'
                else:
                    tblueR,tblueC=moveball(addr,addc,blueR,blueC,b)
                    b[blueR][blueC]='.'
                    b[tblueR][tblueC]='B'
                    if tblueR==goleR and tblueC==goleC:
                        b[tblueR][tblueC]='O'
                    tredR,tredC=moveball(addr,addc,redR,redC,b)
                    b[redR][redC]='.'
                    b[tredR][tredC]='R'
                    if tredR==goleR and tredC==goleC:
                        b[tredR][tredC]='O'
            boardcopy=copy.deepcopy(b)
            b[tredR][tredC]=".";b[tblueR][tblueC]=".";b[blueR][blueC]="B";b[redR][redC]="R";b[goleR][goleC]="O"
            # print(depth,tredR,tredC,tblueR,tblueC)
            if (tblueR==goleR and tblueC==goleC) or depth==10:
                continue
            if tredR==goleR and tredC==goleC:
                print(depth+1)
                exit(0)
            if (tredR,tredC,tblueR,tblueC) not in check:
                dq.append([depth+1,tredR,tredC,tblueR,tblueC,boardcopy])
        if depth==10:
            print(-1)
            exit(0)
print(-1)