N=int(input())
seq=list(map(int,input().split()))
dp=[0]*N
# print(seq)

for idx,num in enumerate(seq):
    tmp=set()
    tmp.add(0)
    for cur in range(idx,-1,-1):
        if seq[cur]>num:
            tmp.add(dp[cur])
    dp[idx]=max(tmp)+1
print(max(dp))
