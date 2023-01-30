import sys
sys.setrecursionlimit(10**7)
number="2455471"	
k=4

def solution(number, k):
    
    L=len(number)
    now_num=L-k
    answer=[]
    def solv(idx,remain):
        nonlocal L
        if remain==0:
            return
        maxa=-1
        for i in range(idx,L-remain+1):
            if maxa==9:
                break
            if maxa<int(number[i]):
                maxa=int(number[i])
                idx=i
            
        answer.append(maxa)
        solv(idx+1,remain-1)
    solv(0,now_num)
    ans=''.join(str(i) for i in answer)
    return ans
solution(number, k)