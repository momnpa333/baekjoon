from collections import deque
import sys
sys.setrecursionlimit(10**7)
N=int(input())

medi=deque(list(map(str,input())))
L=len(medi)
op=['B','L','D']
cnt=0
dp=[[[-1,-1,-1] for _ in range(L)] for _ in range(L)]
def answer(l,r,choice):
    if l>r:
        return 0
    
    if dp[l][r][choice]!=-1:
        return dp[l][r][choice]
    
    ret=0
    if op[choice]==medi[l]:
        ret=answer(l+1,r,(choice+1)%3)+1

    if op[choice]==medi[r]:
        ret=max(ret,answer(l,r-1,(choice+1)%3)+1)
    
    dp[l][r][choice]=ret
    return ret

answer(0,L-1,0)
print(dp[0][L-1][0])
    
    