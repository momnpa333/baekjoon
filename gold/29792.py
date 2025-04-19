import math
N,M,K=map(int,input().split())

characters=[]
for _ in range(N):
    characters.append(int(input()))

characters=sorted(characters,key=lambda x:-x)
boss=[list(map(int,input().split())) for _ in range(K)]

def find_value(damage,boss):
    dp=[0]*(60*15+1)

    for r in range(len(boss)):
        for time in range(60*15,math.ceil(boss[r][0]/damage)-1,-1):
            dp[time]=max(dp[time],dp[time-math.ceil(boss[r][0]/damage)]+boss[r][1])
    return dp[60*15]

answer=0
for damage in characters[:M]:
    answer+=find_value(damage,boss)

print(answer)
# print(3/3)