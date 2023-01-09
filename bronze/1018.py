import sys

input=sys.stdin.readline
row,col = map(int,input().split())

chess_board=[list(input().strip()) for _ in range(row)]

print(chess_board)


    
