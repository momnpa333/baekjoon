import sys
from math import log,ceil
input=sys.stdin.readline

N,M,K=map(int,input().split())
nums=[0]+[int(input()) for _ in range(N)]
H=ceil(log(N,2))
seg_tree=[0]+[0]*(2**(H+1)-1)
lazy=[0]+[0]*(2**(H+1)-1)
def make_tree(left,right,idx):
    if left==right:
        seg_tree[idx]=nums[left]
        return seg_tree[idx]
    mid=(left+right)//2
    seg_tree[idx]=make_tree(left,mid,idx*2)+make_tree(mid+1,right,idx*2+1)
    return seg_tree[idx]

def add_range(left,right,idx,start,end,value):

    if start>right or end<left:
        return
    if left==right:
        seg_tree[idx]+=value
        return
    if left>=start and right<=end:
        lazy[idx]+=value
        return
    seg_tree[idx]+=find_range(left,right,start,end)*value
    mid=(left+right)//2
    add_range(left,mid,idx*2,start,end,value)
    add_range(mid+1,right,idx*2+1,start,end,value)

def update_lazy(left,right,idx):
    if lazy[idx]!=0:
        seg_tree[idx]+=(right-left+1)*lazy[idx]
        if left!=right:
            lazy[idx*2]+=lazy[idx]; lazy[idx*2+1]+=lazy[idx]
        lazy[idx]=0

def find_range(left,right,start,end):
   return min(right,end)-max(left,start)+1

def find_tree(left,right,idx,start,end):
    if start>right or end<left:
        return 0
    update_lazy(left,right,idx)

    if left==right:
        return seg_tree[idx]
    if left>=start and right<=end:
        return seg_tree[idx]

    mid=(left+right)//2
    return find_tree(left,mid,idx*2,start,end)+find_tree(mid+1,right,idx*2+1,start,end)


make_tree(1,N,1)


for _ in range(M+K):
    op=list(map(int,input().split()))
    if op[0]==1:
        add_range(1,N,1,op[1],op[2],op[3])
    else:
        print(find_tree(1,N,1,op[1],op[2]))
