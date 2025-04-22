import math
from decimal import Decimal

N,K=map(int,input().split())
dolls=list(map(int,input().split()))
sum=[0]*N
dsum=[0]*N

for idx,doll in enumerate(dolls):
    sum[idx]=sum[idx-1]+doll
    dsum[idx]=dsum[idx-1]+doll**2

def find_v(start,end):
    n=end-start+1; s=0; ds=0

    if start==0:
        s=sum[end]
        ds=dsum[end]
    else:
        s=sum[end]-sum[start-1]
        ds=dsum[end]-dsum[start-1]
    
    v=abs(Decimal(ds)/Decimal(n)-(Decimal(s)/Decimal(n))**2)
    
    return v
answer=float('inf')
for length in range(K,N+1):
    for end in range(length-1,N):
        answer=min(answer,math.sqrt(find_v(end-length+1,end)))
print(answer)

