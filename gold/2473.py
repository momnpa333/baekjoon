N=int(input())
drink=list(map(int,input().split(' ')))

drink=sorted(drink)

def maketwo(target,n):
    # print(drink)
    left=0;right=n
    acid=4000000000
    answer=[drink[left],drink[right]]
    while(left<right):
        # print(left,right,drinkAry[left]+drinkAry[right])
        if abs(drink[left]+drink[right]+target)<abs(acid+target):
            answer=[drink[left],drink[right]]
            acid=drink[left]+drink[right]
        if drink[left]+drink[right]+target<0:
            left+=1
        elif drink[left]+drink[right]+target>0:
            right-=1
        else:
            break
    return answer

N=len(drink)
ret=3000000001
for i in range(N,2,-1):
    a,b=maketwo(drink[i-1],i-2)
    # print(a,b)
    if abs(a+b+drink[i-1])<abs(ret):
        answer1=[a,b,drink[i-1]]
        ret=a+b+drink[i-1]
print(*answer1)
