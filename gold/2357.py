from math import ceil,log
import sys
input=sys.stdin.readline

N,M=map(int,input().split())

nums=[float('inf')]+[int(input()) for _ in range(N)]
H=ceil(log(N,2))
seg_tree=[[0,0]]+[[0,0] for _ in range(2**(H+1)-1)]

def make_tree(left,right,idx):
    print(left,right,idx)
    if left==right:
        seg_tree[idx]=[nums[left],nums[left]]
        return seg_tree[idx]

    mid=(left+right)//2
    left_child=make_tree(left,mid,idx*2); right_child=make_tree(mid+1,right,idx*2+1)
    seg_tree[idx][0]=max(left_child[0],right_child[0])
    seg_tree[idx][1]=min(left_child[1],right_child[1])

    return seg_tree[idx]

def find_tree(left,right,idx,start,end):
    if start<=left and end>=right:
        return seg_tree[idx]
    if start>right or end<left:
        return [-float('inf'),float('inf')]
    mid=(left+right)//2
    left=find_tree(left,mid,idx*2,start,end)
    right=find_tree(mid+1,right,idx*2+1,start,end)

    return [max(left[0],right[0]),min(left[1],right[1])]




make_tree(1,N,1)

for _ in range(M):
    start,end=map(int,input().split())
    big,small=find_tree(1,N,1,start,end)
    print(small,big)
