N,M=map(int,input().split(' '))

trees=list(map(int,input().split(' ')))
answer=[]
def biSearch(first,last,M):
    if first>last:
        return None
    mid=(first+last)//2
    if isPosi(mid,M):
        biSearch(mid+1,last,M)
        answer.append(mid)
    else:
        biSearch(first,mid-1,M)
def isPosi(mid,M):
    treesum=0
    for tree in trees:
        treesum+=max(tree-mid,0)
    if treesum>=M:
        return True
    return False

# print(trees)
biSearch(0,max(trees),M)
print(max(answer))
