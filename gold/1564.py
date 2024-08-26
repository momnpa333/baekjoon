import sys
sys.setrecursionlimit(10**8)

N=int(input())

# while True:
#     pass

def fact(N):
    if N==1:
        return 1
    num=(fact(N-1)*N)
    while True:
        if num%10==0:
            num=int(num/10)
        else:
            num=num%100000
            break
    return num

num=1
for i in range(1,N+1):
    num*=i
    while True:
        if num%10==0:
            num=int(num/10)
        else:
            num=num%100000000000
            break
num=str(num)



if len(num)>5:
    print(num[-5:])
else:
    print("0"*(5-len(num))+num)