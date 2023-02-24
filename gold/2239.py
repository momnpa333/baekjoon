import sys
input=sys.stdin.readline

sudoku=list(list(map(int,input().split())) for i in range(9))

numset=set([1,2,3,4,5,6,7,8,9])
def linecheck(row,col):
    numset=set([1,2,3,4,5,6,7,8,9])
    numset-=set(sudoku[row])
    for i in range(9):
        numset-={sudoku[i][col]}
    return numset
def squarecheck(row,col):
    numset=set([1,2,3,4,5,6,7,8,9])
    for i in range(row//3*3,row//3*3+3):
        for j in range(col//3*3,col//3*3+3):
            numset-={sudoku[i][j]}

    return numset

            


for i in range(9):
    for j in range(9):
        if sudoku[i][j]==0:
            posipleset={}
            posibleset=linecheck(i,j)&squarecheck(i,j)
            if posibleset:
                sudoku[i][j]=min(list(posibleset))
for nmu in sudoku:
    print(*nmu)

            

