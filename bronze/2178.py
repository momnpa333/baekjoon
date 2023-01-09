import sys
input=sys.stdin.readline

row,col=map(int,input().split())
maze=[list(map(int,input().strip())) for i in range(row)]
print(maze)