cnt=0
n=int(input())
for a in range(1,501):
    for b in range(1,(a+1)):
        if b**2+n==a**2:
            cnt+=1
print(cnt)