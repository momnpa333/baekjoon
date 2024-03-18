N=int(input())
k=int(input())

def makeseq(n):
    seqary=[]
    isum=0
    for i in range(1,n+1):
        isum+=i
        col=i
        row=1
        seqary.append([row,col,isum])
    
    for i in range(n-1,0,-1):
        isum+=i
        col=n
        row=n-i+1
        seqary.append([row,col,isum])
    return seqary

def makesub(num,N):
    subary=[]
    if num<=N:
        for i in range(1,num+1):
            subary.append((num+1-i)*i)
    else:
        row=num-N
        num=2*N-num
        for i in range(1,num+1):
            subary.append((row+i)*(N-i+1))
    return subary

seqary=makeseq(N)

index=0
for item in seqary:
    index+=1
    if k<=item[2]:
        break
subary=makesub(index,N)
print(index)
# print(subary)
subary=sorted(subary)
# print(k-seqary[index-2][2])
print(subary[k-seqary[index-1][2]-1])





