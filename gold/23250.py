from collections import defaultdict

N,K=map(int,input().split(" "))
history=[]
left=1;right=2**N-1
def hanoi(start,via,end,n,left,right):
    global K
    mid=(left+right)//2
    
    if K<mid:
        hanoi(start,end,via,n-1,left,mid-1)#(1~3)
    if K==mid:
        print(start,end)
        exit(0)
    if K>mid:
        hanoi(via,start,end,n-1,mid+1,right)#(5~7)

hanoi(1,2,3,N,left,right)

