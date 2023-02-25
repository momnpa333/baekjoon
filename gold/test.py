import sys
from collections import deque

# 매 branch마다 경우의 수가 매번 약 4*10개이고, 최단경로를 구해야 해서 dfs로는 답을 만나도 나머지 모두 탐색해야 하니 bfs


def bfs(start, end):
    queue = deque()
    queue.append(start)
    visited = set()
    visited.add(start)

    depth = 0
    while queue:
        size = len(queue)
        for _ in range(size):
            num = queue.popleft()
            if num == end:
                return depth

            for i in range(4):
                for j in range(10):
                    # string은 immutable이라 slicing으로 편집
                    new_num = int(str(num)[:i] + str(j) + str(num)[i + 1:])
                    if 1000 < new_num < 10000 and new_num not in visited and era_tos[new_num]:
                        queue.append(new_num)
                        visited.add(new_num)
        depth += 1

    return -1


# 빠른 소수 판단을 위해 에라토스테네스의 체 사용
era_tos = [True for i in range(10000)]
era_tos[0] = False
era_tos[1] = False
for i in range(2, 10000):
    for j in range(2, 10000 // i):
        era_tos[i * j] = False

print()

T = int(sys.stdin.readline())
for t in range(T):
    start, end = map(int, sys.stdin.readline().split())
    result = bfs(start, end)
    if result >= 0:
        print(result)
    else:
        print("Impossible")