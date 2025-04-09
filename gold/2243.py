import sys
from math import ceil,log
input = sys.stdin.readline
L=1000000
nums=[0]*(L+1)
# nums=[0]+[i for i in range(1,L+1)]
H=ceil(log(L,2))
seg_tree=[0]+[0]*(2**(H+1)-1)
N = int(input())

def make_tree(left,right,idx):
    if left==right:
        seg_tree[idx]=nums[left]
        return seg_tree[idx]
    mid=(left+right)//2
    seg_tree[idx]=make_tree(left,mid,idx*2)+make_tree(mid+1,right,idx*2+1)
    return seg_tree[idx]

def update_tree(left,right,idx,dif,target):
    seg_tree[idx]+=dif
    if left==right:
        return
    mid=(left+right)//2
    if left<=target<=mid:
        update_tree(left,mid,idx*2,dif,target)
    else:
        update_tree(mid+1,right,idx*2+1,dif,target)

def choice_candi(left,right,idx,rank):
    seg_tree[idx]-=1
    if left==right:
        if rank>nums[left]:
            return -1
        return left
    mid=(left+right)//2
    if rank<=seg_tree[idx*2]:
        return choice_candi(left,mid,idx*2,rank)
    elif rank>seg_tree[idx*2]:
        return choice_candi(mid+1,right,idx*2+1,rank-seg_tree[idx*2])


make_tree(1,L,1)

for _ in range(N):
    op = list(map(int, input().split()))
    #사탕 줄 때 
    if op[0] == 1:
        tar=choice_candi(1,L,1,op[1])
        nums[tar]-=1
        print(tar)
    else:
        #사탕 넣을 때
        dif=op[2]
        target=op[1]
        update_tree(1,L,1,dif,target)
        nums[target]+=dif
