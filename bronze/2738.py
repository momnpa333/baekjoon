import sys
input = sys.stdin.readline

row,col=map(int,input().split())

matrix1=[list(map(int,input().split())) for _ in range(row)]
matrix2=[list(map(int,input().split())) for _ in range(row)]

for i in range(row):
    for j in range(col):
        matrix1[i][j] = matrix1[i][j]+matrix2[i][j]
for i in matrix1:
    for j in i:
        print(j,end=" ")
    print()


