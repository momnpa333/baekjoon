# from collections import deque

# N=int(input())

# board=[list(map(int,input().split())) for _ in range(N)]
# dp=[[[] for _ in range(N)]for _ in range(N)]

# dq=deque([])
# dq.append((0,0))

# def lis(seq):
#     L=len(seq)
#     dp=[1]*L

#     for i in range(L):
#         for j in range(i):
#             if seq[i]>seq[j]:
#                 dp[i]=max(dp[j]+1,dp[i])
#     return max(dp)

# check=[[True]*N for _ in range(N)]
# search=[]
# while dq:
#     for _ in range(len(dq)):
#         r,c=dq.popleft()
#         for addr,addc in ((0,1),(1,0)):
#             R=addr+r; C=addc+c
#             if 0<=R<N and 0<=C<N and check[R][C]==True:
#                 check[R][C]=False
#                 dq.append((R,C))
#                 search.append((R,C))

# dp[0][0]=[board[0][0]]

# for r,c in search:
#     for addr, addc in ((0,-1),(-1,0)):
#         R=r+addr; C=c+addc
#         cnt=0
#         if 0<=R<N and 0<=C<N:
#             cur=dp[R][C]+[board[r][c]]
#             if cnt<lis(cur):
#                 dp[r][c]=cur
# print(lis(dp[N-1][N-1]))
# print(dp)
from bisect import bisect_left

N = int(input())
grid = [list(map(int, input().split())) for _ in range(N)]

# dp[y][x] = 해당 좌표까지 오는 경로 중 가장 긴 LIS 배열
dp = [[[] for _ in range(N)] for _ in range(N)]

dp[0][0] = [grid[0][0]]

for y in range(N):
    for x in range(N):
        current = grid[y][x]
        candidates = []

        if y > 0:
            candidates.append(dp[y-1][x])
        if x > 0:
            candidates.append(dp[y][x-1])

        best = max(candidates, key=lambda lis: len(lis)) if candidates else []

        # best를 기반으로 새로운 LIS 만들기
        new_lis = best[:]
        idx = bisect_left(new_lis, current)
        if idx == len(new_lis):
            new_lis.append(current)
        else:
            new_lis[idx] = current
        dp[y][x] = new_lis

print(len(dp[N-1][N-1]))

