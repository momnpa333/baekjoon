import sys
input=sys.stdin.readline

N,M=map(int,input().split())
city=[list(map(int,input().split()))for _ in range(N)]
print(city)
foodInfo=[]
userInfo=[]
#치킨정보 저장
for i in range(N):
    for j in range(N):
        if city[i][j] == 2:
            foodInfo.append([i,j])
        if city[i][j] == 1:
            userInfo.append([i,j])
def foodlength(foods):
    foodlength=9999999
    foodsum=0
    for user in userInfo:
        for food in foods:
            if foodlength>abs(user[0]-food[0])+abs(user[1]-food[1]):
                foodlength=(abs(user[0]-food[0])+abs(user[1]-food[1]))
        else:
            foodsum+=foodlength
            foodlength=9999999
    return foodsum
answer=[]
def dfs(currentChicken,idx,chickenNum):
    if chickenNum==M:
        answer.append(foodlength(currentChicken))
        return
    if chickenNum>=M or idx>len(foodInfo)-1:
        return
    dfs(currentChicken,idx+1,chickenNum)
    currentChicken.append(foodInfo[idx])
    dfs(currentChicken,idx+1,chickenNum+1)
tmp=[]
dfs(tmp,0,0)
print((answer))








