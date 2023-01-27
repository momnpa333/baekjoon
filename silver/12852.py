import sys
input=sys.stdin.readline
N=int(input())
dp=[0,0]
answer=[0,0]

for i in range(2,N+1):
    if i%3==0 and i%2==0:
        dp.append(min(dp[i//3]+1,dp[i//2]+1,dp[i-1]+1))
        if min(dp[i//3]+1,dp[i//2]+1,dp[i-1]+1)==dp[i//3]+1:
            answer.append(3)
        elif min(dp[i//3]+1,dp[i//2]+1,dp[i-1]+1)==dp[i//2]+1:
            answer.append(2) 
        else:
            answer.append(1)
    elif i%2==0:
        dp.append(min(dp[i//2]+1,dp[i-1]+1))
        if min(dp[i//2]+1,dp[i-1]+1)==dp[i//2]+1:
            answer.append(2) 
        else:
            answer.append(1)
    elif i%3==0:
        dp.append(min(dp[i//3]+1,dp[i-1]+1))
        if min(dp[i//3]+1,dp[i-1]+1)==dp[i//3]+1:
            answer.append(3) 
        else:
            answer.append(1)
    else:
        dp.append(dp[i-1]+1)
        answer.append(1)
print(dp[N])
while(N!=1):
    print(N,end=" ")
    if answer[N]==1:
        N-=1
    elif answer[N]==2:
        N//=2
    elif answer[N]==3:
        N//=3
print(1)

