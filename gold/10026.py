import sys

N=int(input())

drawing=[list(input().strip()) for _ in range(N)]

blind=[list("B"*N) for _ in range(N)]
for i in range(N):
    for j in range(N):
        if drawing[i][j] =="R":
            blind[i][j]='G'
print(drawing)
print(blind)
