N=int(input())
drinkAry=list(map(int,input().split(' ')))

drinkAry=sorted(drinkAry)
# print(drinkAry)

left=0;right=len(drinkAry)-1
acid=drinkAry[left]+drinkAry[-1]
answer=[drinkAry[left],drinkAry[right]]
while(left<right):
    # print(left,right,drinkAry[left]+drinkAry[right])
    if abs(drinkAry[left]+drinkAry[right])<abs(acid):
        answer=[drinkAry[left],drinkAry[right]]
        acid=drinkAry[left]+drinkAry[right]
    if drinkAry[left]+drinkAry[right]<0:
        left+=1
    elif drinkAry[left]+drinkAry[right]>0:
        right-=1
    else:
        break
print(*answer)
