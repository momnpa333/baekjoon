import sys
input = sys.stdin.readline

matrix = []
N = int(input())
for _ in range(N):
    A, B = map(int, input().split())
    matrix.append((A, B))

if N == 1:
    print(0)
    exit(0)

# dp[i][j] : i번째 행렬부터 j번째 행렬까지 곱셈의 최소 비용
dp = [[float('inf')] * N for _ in range(N)]

# 행렬 하나의 곱셈 비용은 0
for i in range(N):
    dp[i][i] = 0

# r은 곱하는 행렬의 개수 - 1
for r in range(1, N):
    for i in range(N - r):
        j = i + r
        # k는 분할점
        for k in range(i, j):
            cost = dp[i][k] + dp[k + 1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1]
            dp[i][j] = min(dp[i][j], cost)

print(dp[0][N - 1])
