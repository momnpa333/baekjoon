N,M=map(int,input().split())
nums=list(map(int,input().split()))
left=min(nums)
right=sum(nums)
answer=float('inf')

def bin_search(left,right):
    global answer
    if left>right:
        return
    mid=(left+right)//2

    ret=solve(mid)
    if len(ret)==M:
        answer=min(answer,mid)
    if len(ret)>M:
        bin_search(mid+1,right)
    else:
        bin_search(left,mid-1)


def solve(mid):
    cnt=0;cur=0;L=len(nums);ret=[]
    for idx,n in enumerate(nums):
        if cur+n>mid:
            if cnt==0:
                ret.append(1)
            else:
                ret.append(cnt)
                cnt=1; cur=n
        else:
            cnt+=1;cur+=n
            if M-len(ret)==L-idx:
                ret.append(cnt)
                ret+=[1]*(M-len(ret))
                break                
    else:
        if cnt>0:
            ret.append(cnt)
    return ret

# print(solve(6))
bin_search(left,right)
ret=solve(answer)
idx=0;ans=[]
for r in ret:
    tmp=0
    for _ in range(r):
        tmp+=nums[idx]
        idx+=1
    ans.append(tmp) 
print(max(ans))
print(*ret)