N,X=map(int,input().split())
nums=list(map(int,input().split()))
answer=[]
for i in nums:
    if i<X:
        answer.append(i)
print(*answer)