def solution(n):
    answer=0
    cnt=0
    while True:
        if n%3==1:
            answer+=1*(10**cnt)
            n-=1
        elif n%3==2:
            answer+=2*(10**cnt)
            n-=2
        elif n%3==0:
            answer+=4*(10**cnt)
            n-=3
        if n<=0:
            break
        n//=3
        cnt+=1
        
    return str(answer)