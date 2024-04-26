
# 인체에 치명적인 바이러스를 연구하던 연구소에 승원이가 침입했고, 바이러스를 유출하려고 한다.
# 바이러스는 활성 상태와 비활성 상태가 있다.
# 가장 처음에 모든 바이러스는 비활성 상태이고, 활성 상태인 바이러스는 상하좌우로 인접한 모든 빈 칸으로 동시에 복제되며, 1초가 걸린다.
# 승원이는 연구소의 바이러스 M개를 활성 상태로 변경하려고 한다.

# 연구소는 크기가 N×N인 정사각형으로 나타낼 수 있으며, 정사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽, 바이러스로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다. 
# 활성 바이러스가 비활성 바이러스가 있는 칸으로 가면 비활성 바이러스가 활성으로 변한다.
from itertools import combinations
from collections import deque
import copy

N,M=map(int,input().split(" "))
board=[list(map(int,input().split(" "))) for _ in range(N)]

virusAry=[]

for r in range(N):
    for c in range(N):
        if board[r][c]==2:
            virusAry.append((r,c))
        if board[r][c]==1:
            board[r][c]="-"

def check(board):
    for row in board:
        for item in row:
            if item==0:
                return False
    return True

def spread(board,virusSet):
    dq=deque([])
    for r,c in virusSet:
        dq.append((r,c))
        board[r][c]="!"
    time=0
    # print(virusSet)
    answer=0
    while dq:
        time+=1
        for _ in range(len(dq)):
            curR,curC=dq.popleft()
            for addR,addC in ((0,1),(1,0),(0,-1),(-1,0)):
                R=curR+addR; C=curC+addC
                if 0<=R<N and 0<=C<N and board[R][C]!="-" and board[R][C]!="!":
                    dq.append((R,C))
                    # if board[R][C]!=2:
                    #     isIncrease=1
                    if board[R][C]==0:
                        answer=time
                    board[R][C]="!"
    # print(board)
    if check(board):
        return answer
    return float('inf')


answer=float('inf')
for item in combinations(virusAry,M):
    answer=min(spread(copy.deepcopy(board),item),answer)
if answer==float('inf'):
    print(-1)
else:
    print(answer)

            
