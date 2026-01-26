import sys
sys.setrecursionlimit(10**7)

N=int(input())

board=[list(map(int,input().split())) for _ in range(N)]

check=[[0]*N for _ in range(N)]

# print(check)

def find_size(r,c):
    if check[r][c]!=0:
        return check[r][c]

    size=0

    for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
        R=r+addr; C=c+addc
        if 0<=R<N and 0<=C<N and board[R][C]<board[r][c]:
            size=max(find_size(R,C),size) 
    check[r][c]=size+1
    return check[r][c]

for i in range(N):
    for j in range(N):
        find_size(i,j)

solve=0

for r in check:
    solve=max(solve,max(r))
print(solve)