N,M=map(int,(input().split(' ')))

board=[list(map(str,input()))for _ in range(N)]
# print(board)

wboard=[['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'], ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'], ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'], ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'], ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'], ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'], ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'], ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W']]
bboard=[item[1:]+[item[0]] for item in wboard]

answer=float('inf')

def getanswer(startr,startc):
    retw=0;retb=0
    for r in range(8):
        for c in range(8):
            if board[r+startr][c+startc] !=wboard[r][c]:
                retw+=1
            if board[r+startr][c+startc] !=bboard[r][c]:
                retb+=1

    return min(retw,retb)

for startR in range(N-8+1):
    for startC in range(M-8+1):
        answer=min(answer,getanswer(startR, startC))

print(answer)