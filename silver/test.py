import sys
sys.setrecursionlimit(10**7)


def dfs(vx, vy):
    global v1, o1
    maze1[vx][vy] = '#'

    if maze1[vx + 1][vy] != '#':
        if maze1[vx + 1][vy] == 'v':
            v1 = v1 + 1
        elif maze1[vx + 1][vy] == 'o':
            o1 = o1 + 1
        dfs(vx + 1, vy)
    if maze1[vx][vy+1] != '#':
        if maze1[vx][vy + 1] == 'v':
            v1 = v1 + 1
        elif maze1[vx][vy + 1] == 'o':
            o1 = o1 + 1
        dfs(vx, vy + 1)
    if maze1[vx - 1][vy] != '#':
        if maze1[vx - 1][vy] == 'v':
            v1 = v1 + 1
        elif maze1[vx - 1][vy] == 'o':
            o1 = o1 + 1
        dfs(vx - 1, vy)
    if maze1[vx][vy - 1] != '#':
        if maze1[vx][vy - 1] == 'v':
            v1 = v1 + 1
        elif maze1[vx][vy - 1] == 'o':
            o1 = o1 + 1
        dfs(vx, vy - 1)


r, c = map(int, input().split())
maze1 = [['#']*(c+2) for i in range(r+2)]

for i in range(1, r + 1):
    temp = input()
    for j in range(1, c + 1):
        maze1[i][j] = temp[j-1]

global v1
global o1
v1 = 0
o1 = 0

vsum ,osum = 0, 0

for i in range(1, r+1):
    for j in range(1, c+1):
        if maze1[i][j] != '#':
            if maze1[i][j] == 'v':
                v1 = v1 + 1
            elif maze1[i][j] == 'o':
                o1 = o1 + 1
            dfs(i, j)
            if v1 >= o1:
                vsum += v1
            else:
                osum += o1
            v1, o1 = 0, 0
print(osum, vsum)
