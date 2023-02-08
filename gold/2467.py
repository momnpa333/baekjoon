import sys
from itertools import combinations

input=sys.stdin.readline

n=int(input())
liquid=list(map(int,input().split()))

left=0
right=n-1
answer=2000000001
ansright=0
while left<right:
    if(liquid[left]+liquid[right])>0:
        if abs(liquid[left]+liquid[right])<abs(answer):
            answer=abs(liquid[left]+liquid[right])
            ansleft,ansright=left,right
        right-=1
    elif(liquid[left]+liquid[right])<0:
        if abs(liquid[left]+liquid[right])<abs(answer):
            answer=abs(liquid[left]+liquid[right])
            ansleft,ansright=left,right
        left+=1
    else:
        print(liquid[left],liquid[right])
        break
else:
    print(liquid[ansleft],liquid[ansright])
        
        
