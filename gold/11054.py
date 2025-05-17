N=int(input())
seq=list(map(int,input().split()))

ans=-1

def solve(i,seq):
    dp=[1]*(N)

    left_max=0;right_max=0

    for left in range(i,-1,-1):
        tmp=0
        for t in range(left,i+1):
            if seq[t]<=seq[i] and seq[left]<seq[t]:
                tmp=max(tmp,dp[t]+1)       
        dp[left]=tmp   
        left_max=max(left_max,dp[left])      

    
    
    for right in range(i,N):
        tmp=0
        for t in range(right,i-1,-1):
            if seq[t]<=seq[i] and seq[right]<seq[t]:
                tmp=max(tmp,dp[t]+1)
        dp[right]=tmp
        right_max=max(right_max,dp[right])      
    # print(dp,left_max,right_max)
    return left_max+right_max+1


for i in range(N):
    ans=max(ans,solve(i,seq))
print(ans)