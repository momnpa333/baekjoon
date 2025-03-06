    

N=int(input())
M=int(input())
brokenSet=set(map(str,input().split()))
answer1=float('inf');answer2=float('inf');count=0

def isPossible(N):
    for s in str(N):
        if s in brokenSet:
            return False
    return True
up=N;down=N
while down>-1:
    if down==100:
        answer1=count
        break
    if isPossible(down):
        answer1=min(abs(100-down)+count,len(str(down))+count)
        break
    down-=1;count+=1
count=0
while True:
    if up==100:
        answer2=count
        break
    if isPossible(up):
        answer2=min(abs(100-up)+count,len(str(up))+count)
        break
    up+=1;count+=1
print(min(answer1,answer2))
