N=int(input())
info=list(map(int,input().split()))
answer=[0]*N

for i in range(N):
    for j in range(N):
        if answer[j]==0 and info[i]==0:
            answer[j]=i+1
            break
        elif answer[j]==0:
            info[i]-=1
        
print(*answer)
