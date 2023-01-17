import sys
input=sys.stdin.readline

N=int(input())
cardList=list(map(int, input().split()))
M=int(input())
keyList=list(map(int, input().split()))

dic={}
for i in cardList:
    if( i in dic):
        dic[i]+=1
    else:
        dic[i]=1

for k in keyList:
    if( k in dic):
        print(dic[k],end=' ')
    else:
        print(0,end=' ')

