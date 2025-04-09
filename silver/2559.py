N,K=map(int,input().split())
temper=list(map(int,input().split()))

cur=sum(temper[:K])
answer=cur

for idx,i in enumerate(range(K,N)):
    cur+=temper[i]
    cur-=temper[idx]
    answer=max(answer,cur)

print(answer)