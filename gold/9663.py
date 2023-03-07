import sys

# key. 한 행에 하나씩 들어감-> for 문은 j 열만 돌리면 됨 -> 반복을 줄려 시간 줄이기
# key. 대각선에 놓인 두 점: i차 == j차 -> 방문 기록을 없애 메모리 줄이기

def dfs(i, j, depth):
    global ans

    if depth == N - 1:
        ans += 1
        return

    for k in range(N):
        if chessboard[i+1][k]==0:
            printing(i+1,k)
            dfs(i+1,k,depth+1)
            returnprinting(i+1,k)

def printing(i,j):
    for k in range(N):
        chessboard[k][j]-=1
        if 0<=i+k<N and 0<=j+k<N:
            chessboard[i+k][j+k]-=1
        if 0<=i+k<N and 0<=j-k<N:
            chessboard[i+k][j-k]-=1 
        
def returnprinting(i,j):
    for k in range(N):
        chessboard[k][j]+=1
        if 0<=i+k<N and 0<=j+k<N:
            chessboard[i+k][j+k]+=1
        if 0<=i+k<N and 0<=j-k<N:
            chessboard[i+k][j-k]+=1 


N = int(sys.stdin.readline())
chessboard = [[0]*(N) for i in range(N)]

ans = 0
for j in range(N):
    printing(0,j)
    dfs(0, j, 0)
    returnprinting(0,j)

print(ans)