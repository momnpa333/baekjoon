import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**7)

global one
one=0
global zero
zero=0
def pivonachi(a):
    if a==1:
        global one
        one+=1
        return 1
    elif a==0:
        global zero
        zero+=1
        return 0

    return pivonachi(a-1)+pivonachi(a-2)



T=int(input())
while T>0:
    pivonachi(int(input()))
    print(one,zero)
    one=0
    zero=0
