import math,sys
input=sys.stdin.readline

N,Q=map(int,input().split())

H=math.ceil(math.log(N,2))

seg_tree=[0]+[0]*(2**(H+1)-1)

money_hist=[0]*(N+1)

def input_money(start,end,idx,dif,tar):
    seg_tree[idx]+=dif
    if start==end and start==tar:   
        return
    mid=(start+end)//2
    if start<=tar<=mid:
        input_money(start,mid,idx*2,dif,tar)
    elif mid+1<=tar<=end:
        input_money(mid+1,end,idx*2+1,dif,tar)




def print_money(start,end,idx,left,right):
    mid=(start+end)//2
    ret=0
    # 1. 완전히 안에 있을 때
    if left<=start and right>=end:
        return seg_tree[idx]
    # 2. 범위 안에 없을 때
    if left>end or right<start:
        return 0
    
    ret+=print_money(start,mid,idx*2,left,right)
    ret+=print_money(mid+1,end,idx*2+1,left,right)
    return ret


for _ in range(Q):
    op,A,B=map(int,input().split())

    if op==1:
        input_money(1,N,1,B,A)
    elif op==2:
        print(print_money(1,N,1,A,B))
