import sys
from collections import Counter
input=sys.stdin.readline

def make_pizza_candi(pizza):
    L=len(pizza)
    dp=[[0]*L for _ in range(L)]
    for r in range(L):
        for c in range(L):
            if r==c:
                dp[r][c]=pizza[r]
    
    for r in range(L):
        for c in range(r+1,L):
            dp[r][c]=dp[r][c-1]+pizza[c]
    
    for r in range(L):
        for c in range(r):
            dp[r][c]=dp[r][c-1]+pizza[c]
    ret=[]
    for row in dp:
        ret+=row
    return sorted(ret)[:-(L-1)]
    

size=int(input())
M,N=map(int,input().split())
pizzaA=[int(input()) for _ in range(M)]; pizzaB=[int(input()) for _ in range(N)]

pizzaA=Counter(make_pizza_candi(pizzaA))
pizzaB=Counter(make_pizza_candi(pizzaB))


answer=0
answer+=pizzaA[size]+pizzaB[size]

for a in pizzaA:
    b=size-a
    if b in pizzaB:
        answer+=pizzaA[a]*pizzaB[b]

# print(pizzaA,pizzaB)
print(answer)


