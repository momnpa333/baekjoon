# # 가장 처음에 양분은 모든 칸에 5만큼 들어있다.
# # 이 나무는 사계절을 보내며, 아래와 같은 과정을 반복한다.

# # 봄에는 나무가 자신의 나이만큼 양분을 먹고, 
# 나이가 1 증가한다. 
# 각각의 나무는 나무가 있는 1×1 크기의 칸에 있는 양분만 먹을 수 있다.
#  하나의 칸에 여러 개의 나무가 있다면, 
# 나이가 어린 나무부터 양분을 먹는다. 
# 만약, 땅에 양분이 부족해 자신의 나이만큼 
# 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.

# # 여름에는 봄에 죽은 나무가 양분으로 변하게 된다.
#  각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 
# 양분으로 추가된다. 소수점 아래는 버린다.

# # 가을에는 나무가 번식한다. 
# 번식하는 나무는 나이가 5의 배수이어야 하며, 
# 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
# 어떤 칸 (r, c)와 인접한 칸은 (r-1, c-1), (r-1, c), (r-1, c+1), (r, c-1), (r, c+1), (r+1, c-1), (r+1, c), (r+1, c+1) 이다. 
# 상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.

# # 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다.
#  각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
import sys
from collections import deque
input=sys.stdin.readline

N,M,K=map(int,input().split(' '))

origin=[list(map(int,input().split(" "))) for _ in range(N)]
board=[[5]*N for _ in range(N)]
trees=[[deque([])for _ in range(N)] for _ in range(N)]
tmp=[]
for _ in range(M):
    R,C,age=map(int,input().split(' '))
    tmp.append((age,R,C))

tmp=sorted(tmp)
for age,R,C in tmp:
    trees[R-1][C-1].append(age)

def spring():
    global N
    for r in range(N):
        for c in range(N):
            grow=[];dead=[]
            for _ in range(len(trees[r][c])):
                treeAge=trees[r][c].popleft()
                if treeAge<=board[r][c]:
                    trees[r][c].append(treeAge+1)
                    board[r][c]-=treeAge
                else:
                    dead.append((r,c,treeAge//2))
            else:
                for r,c,value in dead:
                    board[r][c]+=value

def autumn():
    tmp=[]
    for r in range(N):
        for c in range(N):
            for treeAge in trees[r][c]:
                if treeAge%5==0:
                    for addr,addc in ((0,1),(1,1),(1,0),(1,-1),(0,-1),(-1,-1),(-1,0),(-1,1)):
                        R=r+addr; C=c+addc
                        if 0<=R<N and 0<=C<N:
                            tmp.append((R,C))
    for r,c in tmp:
        trees[r][c].appendleft(1)

def winter():
    for r in range(N):
        for c in range(N):
            board[r][c]+=origin[r][c]

answer=0
for i in range(1,K+1):
    spring()
    autumn()
    winter()
else:
    for r in range(N):
        for c in range(N):
            answer+=len(trees[r][c])
print(answer)





                
