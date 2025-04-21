n=int(input())

memo=dict()

memo[0]=0; memo[1]=1; memo[2]=1

def fivo(N):
    if N in memo:
        return memo[N]
    if N%2==0:
        ret=(2*fivo(N//2-1)*fivo(N//2)+fivo(N//2)**2)%1000000
        memo[N]=ret
        return ret
    else:
        ret=(fivo(N//2+1)**2+fivo(N//2)**2)%1000000
        memo[N]=ret
        return ret

print(fivo(n))

