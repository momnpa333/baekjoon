import sys
input=sys.stdin.readline
N=int(input())
schedule=list(list(map(int,input().split())) for _ in range(N))
dp=[]
max=0
for i in range(N):
    if(schedule[i][0]+i<=N):
        dp.append([schedule[i][1],i+1,i+schedule[i][0]])
    #합치기
    try:
        for j in range(len(dp)):
            if dp[j][2]==i+1:
                for t in range(len(dp)):
                    if dp[t][2]<dp[j][1]:
                        dp[t][0]+=dp[j][0]
                        dp[t][2]=dp[j][2]
                        dp.pop(j)
                        j-=1
                        break
    except:
        tm='sry'
    #비교후 삭제
    try:
        for k in range(len(dp)):
            if dp[k][2]<=(i+1):
                if max<=dp[k][0]:
                    max=dp[k][0]
                    answer=dp[k][0]
                else:
                    dp.pop(k)
                    k-=1
    except:
        tm='dsaf'
#print(dp)
print(answer)



