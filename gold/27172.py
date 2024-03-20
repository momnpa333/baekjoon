from itertools import combinations

N=int(input())
cards=list(map(int,input().split(' ')))

numary=[False]*1000001

for card in cards:
    numary[card]=0

for card in cards:
    tmp=card
    card+=tmp
    while card<len(numary):
        if type(numary[card])==int:
            numary[card]-=1
            numary[tmp]+=1
        card+=tmp

for card in cards:
    print(numary[card],end=' ')

