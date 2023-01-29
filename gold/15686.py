import sys
input=sys.stdin.readline

N,M=map(int,input().split())
city=[list(map(int,input().split()))for _ in range(N)]
print(city)
foodInfo=[]
userInfo=[]
foodlength=9999999
#치킨정보 저장
for i in range(N):
    for j in range(N):
        if city[i][j] == 2:
            foodInfo.append([i,j])
        if city[i][j] == 1:
            userInfo.append([i,j])

for user in userInfo:
    for food in foodInfo:
        if foodlength>abs(user[0]-food[0])+abs(user[1]-food[1]):
            foodlength=abs(user[0]-food[0])+abs(user[1]-food[1])



    

