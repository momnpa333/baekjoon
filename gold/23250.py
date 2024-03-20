from collections import defaultdict

N,K=map(int,input().split(" "))

hanoidict=defaultdict(list)


def hanoi(n,start,via,end):
    if n==1:
        hanoidict[(start,via,end)]=[[start,end]]
        return [[start,end]]

    if hanoidict[(start,end,via)] and len(hanoidict[(start,end,via)])>=2**(n-1)-1:
        run1=hanoidict[(start,end,via)][:2**(n-1)-1]
    else:
        run1=hanoi(n-1,start,end,via)
    # print("n",n,"run1",run1)
    run2=[[start,end]]
    # print("n",n,"run2",run2)
    if hanoidict[(via,start,end)] and len(hanoidict[(via,start,end)])>=2**(n-1)-1:
        run3=hanoidict[(via,start,end)][:2**(n-1)-1]
    else:
        run3=hanoi(n-1,via,start,end)
    # if len(run1+run2+run3)>len(hanoidict[(start,via,end)]):
    #     hanoidict[(start,via,end)]=run1+run2+run3
    # print("n",n,"run3",run3)
    hanoidict[(start,via,end)]=run1+run2+run3
    return run1+run2+run3

for i in range(1,N+1):
    hanoi(i,1,2,3)

print(*hanoidict[(1,2,3)][K-1])
print(hanoidict)


