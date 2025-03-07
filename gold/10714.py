import sys
input = sys.stdin.readline

N = int(input())
cake = [int(input()) for _ in range(N)]
dp=[[0]*N for _ in range(N)]

def choice(front,rear):
    # print(front,rear)
    if dp[front][rear]!=0:
        return dp[front][rear]
    
    if front==rear:
        dp[front][rear]=cake[front]
    elif abs(rear-front)==1:
        dp[front][rear]=max(cake[front],cake[rear])
    
    elif (rear-front)%2==1:
        dp[front][rear]=choice((front+1)%N,(rear-1)%N)
    else:
        dp[front][rear]=choice((front+1)%N,(rear-1)%N)+max(cake[front],cake[rear])

    return dp[front][rear]

for i in range(N):
    for j in range(N):
        choice(i,j)
# choice(0,1)

print(*dp,sep='\n')