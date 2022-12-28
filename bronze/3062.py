n=int(input())
while True:
    if n == 0:
        break
    n-=1
    ns=input()
    sum=int(ns[::-1])+int(ns)
    sum=str(sum)
    if sum==sum[::-1]:
        print("YES")
    else:
        print("NO")

    

