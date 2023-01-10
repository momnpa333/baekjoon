import sys
input=sys.stdin.readline

infoAry= [list(map(str,input().strip().split())) for _ in range(int(input()))]
for i in sorted(infoAry,key=lambda info:int(info[0])):
    print(i[0],i[1])

