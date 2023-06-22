from collections import deque

def solution(stones, k):
    answer=987654321
    dq=deque(stones[:k])
    m=max(dq)

    for i in range(k,len(stones)):
        if m<answer:
            answer=m
        
        dq.append(stones[i])
        if m<=dq.popleft() and stones[i]<m:
            m=max(dq)
    else:
        if m<answer:
            answer=m
    
    return answer