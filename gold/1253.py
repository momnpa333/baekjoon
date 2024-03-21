import sys
input=sys.stdin.readline

N=int(input().rstrip())

goods=list(map(int,input().rstrip().split(' ')))
goods=sorted(goods)
answer=0
for i in range(len(goods)-1,-1,-1):
    # print(i)
    target=goods[i]
    left=0; right=len(goods)-1
    if left==i:
        left+=1
    if right==i:
        right-=1
    while left<right:
        # print(target,goods[left],goods[right])
        if left==i:
            left+=1
        if right==i:
            right-=1
        if left>=right:
            break
        if target>goods[left]+goods[right]:
            left+=1
        elif target<goods[left]+goods[right]:
            right-=1
        else:
            # print(target,i,left,right)
            answer+=1
            break

print(answer)
