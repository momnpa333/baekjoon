import sys
input=sys.stdin.readline

n=int(input())
numary=list(map(int,input().split()))
solv=numary[0]
prev=0

for numa in numary:
    if numa>0:
        flag=1
        break
else:
    flag=0

if flag==1:
    for num in numary:
        if num+prev>=0:
            if prev>num+prev:
                if solv<prev:
                    solv=prev
            prev=num+prev
        else:
            if solv<prev:
                solv=prev
            prev=0
    else:
        if solv<prev:
            solv=prev
    print(solv)
else:
    print(max(numary))