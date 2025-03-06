N=int(input())
money=list(map(int,input().split()))
total=int(input())
answer=[]
right=max(money)

def binary_search(left,right,total):
    if left>right:
        return
    cur=0; mid=(left+right)//2
    for pay in money:
        cur+=min(pay,mid)
    if total<cur:
        binary_search(left,mid-1,total)
    else:
        answer.append(mid)
        binary_search(mid+1,right,total)
binary_search(0,right,total)
print(answer)