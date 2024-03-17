# import sys
# input=sys.stdin.readline

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

sudoku=list(list(map(int,list(input()))) for _ in range(9))


check=1
while check:
    candi=[[{}]*9 for _ in range(9)]
    check=0
    for r in range(9):
        for c in range(9):
            if sudoku[r][c]==0:
                candi[r][c]={1,2,3,4,5,6,7,8,9}-(checkRow(sudoku,r)|checkCol(sudoku,c)|square(sudoku,r,c))
                if len(candi[r][c])==1:
                    check=1
                    for i in candi[r][c]:
                        sudoku[r][c]=i
    # print(*sudoku,*candi,sep='\n')
    # for r in range(9):
    #     for c in range(9):
    #         if len(candi[r][c])==1:
    #             check=1
    #             for i in candi[r][c]:
    #                 sudoku[r][c]=i
else:
    for i in sudoku:
        print(*i,sep='')


# print(sudoku)
        