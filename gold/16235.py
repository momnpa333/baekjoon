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
import heapq
import copy
import sys
input=sys.stdin.readline
from collections import deque


N,M,K=map(int,input().split(' '))

origin=[list(map(int,input().split(" "))) for _ in range(N)]
board=[[5]*N for _ in range(N)]
newtrees=[]

for _ in range(M):
    R,C,age=map(int,input().split(' '))
    newtrees.append((age,R-1,C-1))

# print(board)
# print(trees)
newtrees=sorted(newtrees)
newtrees=deque(newtrees)
def spring(trees):
    newtrees=deque([])
    deadtrees=[]
    # print("!!!",trees)
    while trees:
        age,R,C=trees.popleft()
        if board[R][C]>=age:
            board[R][C]-=age
            newtrees.append((age+1,R,C))
        else:
            deadtrees.append((age,R,C))
    # print("!!",newtrees)
    return newtrees,deadtrees

def summer(deadtrees):
    for age,R,C in deadtrees:
        board[R][C]+=age//2

def autum(trees):
    # print(trees)
    # for i in range(len(trees)-1,-1,-1):
    #     age,R,C=trees[i],trees[i+1
    for age,R,C in list(trees)[::-1]:
        if age<5:
            break
        if age%5==0:
            for addr,addc in ((-1,-1), (-1, 0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)):
                newR=R+addr; newC=C+addc
                if 0<=newR<len(board) and 0<=newC<len(board):
                    trees.appendleft((1,newR,newC))
    return trees

def winter():
    for i in range(len(board)):
        for j in range(len(board)):
            board[i][j]+=origin[i][j]
        
for _ in range(K):
    deadtrees=[]
    newtrees,deadtrees=spring(newtrees)
    for age,R,C in deadtrees:
        board[R][C]+=age//2

    newtrees=autum(newtrees)
    winter()
    # print(board,newtrees)
print(len(newtrees))