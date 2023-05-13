A,B=map(int,input().split())
cnt=0
while True:
    if B%2==0:
        B//=2
    elif B%10==1:
        B//=10
    else:
        print("-1")
        break
    cnt+=1
    if A==B:
        print(cnt+1)
        break
    if B<A:
        print("-1")
        break