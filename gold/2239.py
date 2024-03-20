# import sys
# input=sys.stdin.readline
from collections import defaultdict 
import copy

sudoku=list(list(map(int,list(input()))) for _ in range(9))

def checkRow(sudoku,r):
    return set(sudoku[r])

def checkCol(sudoku,c):
    tmp=[i for i in zip(*sudoku)]
    return set(tmp[c])

def square(sudoku,r,c):
    R=r//3; C=c//3
    tmp=set()
    for r in range(3):
        for c in range(3):
            tmp.add(sudoku[R*3+r][C*3+c])
    return set(tmp)

def isposi(r,c,item,board):
    if item in board[r]:
        return False
    if item in list(zip(*board))[c]:
        return False
    R=r//3; C=c//3
    for r in range(3):
        for c in range(3):
            if item == sudoku[R*3+r][C*3+c]:
                return False
    return True


def dfs(depth,board):
    # print(board)
    if depth==len(posiary)-1:
        for item in board:
            tmp=''
            for i in item:
                tmp+=str(i)
            print(tmp)
        exit(0)
        return
    boardcopy=copy.deepcopy(board)

    posiset=posiary[depth][1]
    r,c=posiary[depth][0]
    for item in posiset:
        if isposi(r,c,item,boardcopy):
            boardcopy[r][c]=item
            dfs(depth+1,boardcopy)


posiary=[]
answer=[]
numset={1,2,3,4,5,6,7,8,9}
for r in range(9):
    for c in range(9):
        if sudoku[r][c]==0:
            posiary.append([(r,c),sorted(list(numset-(checkRow(sudoku,r)|checkCol(sudoku,c)|square(sudoku,r,c))))])
posiary.append([(0,0),[0]])
dfs(0,sudoku)
# print(len(posiary))