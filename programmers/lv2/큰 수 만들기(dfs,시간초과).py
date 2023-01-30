import sys
sys.setrecursionlimit(10**7)
number="1231234"	
k=3

def solution(number, k):
    maxdepth=len(number)-k
    answer=[]
    def dfs(currentnum,depth,idx):
        if depth ==maxdepth:
            answer.append(int(''.join(num for num in currentnum)))
            return
        if idx>=len(number):
            return 
        tmp=currentnum.copy()
        dfs(tmp,depth,idx+1)
        currentnum.append(number[idx])
        tmp=currentnum.copy()
        dfs(tmp,depth+1,idx+1)
    dfs([],0,0)
    return str(max(answer))
print(solution(number,k))