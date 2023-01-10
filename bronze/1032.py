import sys
input=sys.stdin.readline


stringAry=[input().strip() for _ in range(int(input()))]

solv=list(stringAry[0])

for i in stringAry:
    for k in range(len(stringAry[0])):
        if(solv[k]!=i[k]):
            solv[k] = '?'
print(''.join(solv))