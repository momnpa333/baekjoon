N=int(input())

nums=sorted(list(map(int,input().split())))

print(nums[0]*nums[-1])