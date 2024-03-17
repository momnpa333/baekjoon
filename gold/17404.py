# # RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
# # 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

# # 1번 집의 색은 2번, N번 집의 색과 같지 않아야 한다.
# # N번 집의 색은 N-1번, 1번 집의 색과 같지 않아야 한다.
# # i(2 ≤ i ≤ N-1)번 집의 색은 i-1, i+1번 집의 색과 같지 않아야 한다.

# # 첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 
# # 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 
# # 1번 집부터 한 줄에 하나씩 주어진다. 
# # 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.

# # 1. 0,1,2로 완탐 돌리기-> bfs로 돌리는데 q가 가격순으로 pq로 구현
# 2. pq 시간초과
# import heapq

# N=int(input())
# aryPrice=[list(map(int,input().split(' '))) for i in range(N)]

# pq = []
# for i in range(3):
#     heapq.heappush(pq,(aryPrice[0][i],[i],0))
# while pq:
#     # print(pq)
#     price,history,L=heapq.heappop(pq)
#     # print(price,history,L)
#     if L==N-1:
#         print(price)
#         exit(0)
#     for i in range(3):
#         if L==N-2:
#             if history[-1]!=i and history[0]!=i:
#                 histc=history[:]
#                 histc.append(i)
#                 heapq.heappush(pq,(price+aryPrice[L+1][i],histc,L+1))     

#         elif history[-1]!=i:
#             histc=history[:]
#             histc.append(i)
#             # print("!",histc)
#             # print((price+aryPrice[L+1][i],history,L+1))
#             heapq.heappush(pq,(price+aryPrice[L+1][i],histc,L+1))     
