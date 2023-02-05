import sys

input=sys.stdin.readline

T=int(input())

cachy=[0]*100
cachy[1]=1
cachy[2]=2
cachy[3]=4

def dfs(num):
    global answer
    if num>=12:
        return
    if cachy[num]!=0:
        return
    if cachy[num]==0:
        cachy[num]=cachy[num-3]+cachy[num-2]+cachy[num-1]
        dfs(num+1)
        dfs(num+2)
        dfs(num+3)
dfs(4)

for i in range(T):
    print(cachy[int(input())])
