from math import log,ceil
import sys
input=sys.stdin.readline
N,M,K=map(int,input().split())

nums=[0]+[int(input()) for _ in range(N)]

H=ceil(log(len(nums)-1,2))
seg_tree=[0]+[0]*(2**(H+1)-1)

def make_tree(idx,left,right):
    if left==right:
        seg_tree[idx]=nums[left]
        return seg_tree[idx]
    
    seg_tree[idx]=make_tree(idx*2,left,(left+right)//2)+make_tree(idx*2+1,(left+right)//2+1,right)
    return seg_tree[idx]

def find_tree(left,right,idx,start,end):
    if end<left or start>right:
        return 0
    if start<=left and end>=right:
        return seg_tree[idx]
    mid=(left+right)//2
    return find_tree(left,mid,idx*2,start,end)+find_tree(mid+1,right,idx*2+1,start,end)
def update_tree(left,right,idx,dif,target):
    seg_tree[idx]+=dif
    if left==right and target==left:
        return
    mid=(left+right)//2
    if left<=target<=mid:
        update_tree(left,mid,idx*2,dif,target)
    else:
        update_tree(mid+1,right,idx*2+1,dif,target)


make_tree(1,1,len(nums)-1)

for _ in range(M+K):
    a,b,c=map(int,input().split())
    if a==1:
        dif=c-nums[b]
        update_tree(1,len(nums)-1,1,dif,b)
        nums[b]=c
    if a==2:
        print(find_tree(1,len(nums)-1,1,b,c))