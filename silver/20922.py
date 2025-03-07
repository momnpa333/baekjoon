from collections import Counter
N,K=map(int,input().split())
answer=0
nums=list(map(int,input().split()))
left=0; right=0
bucket=Counter([nums[0]])
max_freq=1
# print(max(bucket.values()))
while left<=right or right>N:
    if max_freq<=K:
        answer=max(right-left+1,answer); right+=1
        if right==N:
            break
        else:
            bucket[nums[right]]+=1
            max_freq=max(bucket[nums[right]],max_freq)
    else:
        while True:
            if nums[left]==nums[right]:
                bucket[nums[left]]-=1;left+=1;max_freq-=1
                break
            bucket[nums[left]]-=1;left+=1
print(answer)

