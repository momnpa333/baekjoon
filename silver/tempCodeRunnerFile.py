N=int(input())
cnt=0
answer=[]
def hanoi(N,start,via,end):
    global cnt
    cnt+=1
    if N==1:
        print(start,end)
        return
    hanoi(N-1,start,end,via)
    print(start,end)
    hanoi(N-1,via,start,end)

def hanoiV2(N,start,via,end):
    global cnt
    cnt+=1
    if N==1:
        return
    hanoiV2(N-1,start,end,via)
    hanoiV2(N-1,via,start,end)

hanoiV2(N,1,2,3)
if N<=20:
    print(cnt)
    hanoi(N,1,2,3)
    for item in answer:
        print(*item)
else:
    print(cnt)