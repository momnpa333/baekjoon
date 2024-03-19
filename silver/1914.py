from collections import defaultdict

N=int(input())
answer=[]
answerdict=defaultdict(int)

def hanoi(N,start,via,end,cnt):
    cnt+=1
    if N==1:
        answerdict[1]=cnt
        return
    answerdict[N]=answerdict[N-1]*2+1
    return 

def hanoiV2(N,start,via,end):
    if N==1:
        print(start,end)
        return
    hanoiV2(N-1,start,end,via)
    print(start,end)
    hanoiV2(N-1,via,start,end)
for i in range(1,N+1):
    hanoi(i,1,2,3,0)

print(answerdict[N])
if N<=20:
    hanoiV2(N,1,2,3)