from math import log,ceil
import sys
input=sys.stdin.readline

N=int(input())
nums=[0]+list(map(int,input().split()))
H=ceil(log(N,2))
seg_tree=[0]+[0]*(2**(H+1)-1)

def make_tree(left,right,idx):
    if left==right:
        seg_tree[idx]=nums[left]
        return seg_tree[idx]
    mid=(left+right)//2
    seg_tree[idx]=make_tree(left,mid,idx*2)+make_tree(mid+1,right,idx*2+1)

    return seg_tree[idx]

def update_tree(left,right,idx,dif,tar):
    seg_tree[idx]+=dif
    if left==right:
        return
    mid=(left+right)//2
    if left<=tar<=mid:
        update_tree(left,mid,idx*2,dif,tar)
    else:
        update_tree(mid+1,right,idx*2+1,dif,tar)
    
def find_tree(left,right,idx,rank):
    if left==right:
        return left
    mid=(left+right)//2
    if rank<=seg_tree[idx*2]:
        return find_tree(left,mid,idx*2,rank)
    else:
        return find_tree(mid+1,right,idx*2+1,rank-seg_tree[idx*2])


make_tree(1,N,1)

M=int(input())
for _ in range(M):
    op=list(map(int,input().split()))
    if op[0]==1:
        dif=op[2]; tar=op[1]
        update_tree(1,N,1,dif,tar)
    else:
        rank=op[1]
        print(find_tree(1,N,1,rank))

