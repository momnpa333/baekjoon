import sys

input=sys.stdin.readline

N,K=map(int,input().split())

dp=[[ 0 for _ in range(K+1)] for _ in range(N+1)]

item=[list(map(int,input().split())) for _ in range(N)]

#i=item index
for i in range(1,N+1):
    #j=무개
    for j in range(1,K+1):
        #item의 무개가 최대보면 크면 안넣기
        if item[i-1][0]>j:
            dp[i][j]=dp[i-1][j]
        else:
            #item의 무개를 만큼 가방에서 빼고 item을 넣었을때와 그냥 있었을때 비교하기
            dp[i][j]=max(dp[i-1][j],dp[i-1][j-item[i-1][0]]+item[i-1][1])
print(dp[N][K])


