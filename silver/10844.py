# 1000000000 나머지값

N=int(input())

prev_dp=[0,1,1,1,1,1,1,1,1,1]
cur_dp=[0,1,1,1,1,1,1,1,1,1]


for _ in range(N-1):
    cur_dp[0]=prev_dp[1]
    for c in range(1,9):
        cur_dp[c]=prev_dp[c-1]+prev_dp[c+1]
    cur_dp[9]=prev_dp[8]

    prev_dp=cur_dp[:]

print(sum(cur_dp)%1000000000)
