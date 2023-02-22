import sys
input=sys.stdin.readline

N,S=map(int,input().split())

seq=list(map(int,input().split()))

start=0
finish=0
sum=seq[0]
answer=100000001
while start!=N:
    if sum>=S:
        if answer>finish-start+1:
            answer=finish-start+1
            sum-=seq[start]
            if start==finish:
                finish+=1
            start+=1
        else:
            sum-=seq[start]
            if start==finish:
                finish+=1
            start+=1
    elif sum<S:
        if finish!=N-1:
            finish+=1
            sum+=seq[finish]
        else:
            break
if answer==100000001:
    print(0)
else:
    print(answer)
    

