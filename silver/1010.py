import sys
input=sys.stdin.readline
T=int(input())

def solve(n,m):
    left=1; right=1

    for i in range(n):
        left*=m-i
    
    for i in range(n,0,-1):
        right*=i
    
    return left//right


for _ in range(T):
    N,M=map(int,input().split())
    print(solve(N,M))

