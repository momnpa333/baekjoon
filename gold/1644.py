import math

N=int(input())
prime=[]
# prime.append(2)


def makePrime():
    for i in range(2,N+1):
        if isPrime(i):
            prime.append(i)

def isPrime(num):
    for i in range(2,int(math.sqrt(num))+1):
        if num%i==0:
            return False
    return True

makePrime()
answer=0
answer1=0
left=0; right=0
L=len(prime)
cur=0
# print(prime)
while left<L and right<L:
    while cur<N:
        cur+=prime[right]
        answer+=1
        right+=1
        if cur==N:
            answer1+=1
           

    while True:
        cur-=prime[left]
        answer-=1
        left+=1
        if cur==N:
            answer1+=1
        if cur<N:
            break
            
    # print(left,right,L)
    if right==L:
        break
# print(0)
print(answer1)






