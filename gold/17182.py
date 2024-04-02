N,K=map(int,input().split(' '))

board=[list(map(int,input().split(' '))) for _ in range(N)]
check=[False]*(N)
answer=float('inf')
def floyd():
    for via in range(N):
        for start in range(N):
            for end in range(N):
                if board[start][end]>board[start][via]+board[via][end]:
                    board[start][end] = board[start][via]+board[via][end]
def search(node,cost,depth):
    global answer
    global N
    # print(check,node)
    if depth==N-1:
        # print(check,node,cost)
        answer=min(answer,cost)
        return
    for destination in range(N):
        if check[destination]==False:
            check[destination]=True
            search(destination,cost+board[node][destination],depth+1)
            check[destination] = False
floyd()
check[K]=True
search(K,0,0)
print(answer)           

