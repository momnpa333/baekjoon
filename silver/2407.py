import sys
          
input=sys.stdin.readline
n,m=map(int,input().split())

def factorial(s,f):
    solv=1
    cnt=0
    while True:
        solv*=s
        s-=1
        cnt+=1
        if cnt==f:
            break
    return solv
def factorial2(s):
    solv=1
    for i in range(1,s+1):
        solv*=i
    return solv

print(factorial(n,m)//factorial2(m))

