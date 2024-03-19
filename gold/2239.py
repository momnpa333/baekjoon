# import sys
# input=sys.stdin.readline
from collections import defaultdict 

sudoku=list(list(map(int,list(input()))) for _ in range(9))
posidict=defaultdict(set)

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

def dfs()

numset={1,2,3,4,5,6,7,8,9}
for r in range(9):
    for c in range(9):
        if sudoku[r][c]==0:
            posidict[(r,c)]=numset-(checkRow(sudoku,r)|checkCol(sudoku,c)|square(sudoku,r,c))

