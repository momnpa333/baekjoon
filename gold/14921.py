N=int(input())
dif=float('inf')
liq=list(map(int,input().split()))
answer=0
left=0; right=N-1
while left<right:
    S=liq[left]+liq[right]
    if S>0:
        right-=1
    elif S<0:
        left+=1
    else:
        print(S)
        exit(0)

    if abs(S)<dif:
        # print(S,dif)
        dif=abs(S)
        answer=S
print(answer)
