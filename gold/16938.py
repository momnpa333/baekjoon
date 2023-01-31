import sys
input=sys.stdin.readline

N,L,R,X=map(int,input().split())

levels =list(map(int,input().split()))

count=0
def dfs(mint,maxt,S,idx,nowLev):
    global count
    if idx>=len(levels):
        return
    if S>=R:
        return
    tmp=nowLev.copy()
    tmp.append(levels[idx])
    dfs(mint,maxt,S,idx+1,nowLev)
    if S+levels[idx]>=L and S+levels[idx]<=R and max(tmp)-min(tmp)>=X:
        count+=1
    dfs(min(tmp),max(tmp),S+levels[idx],idx+1,tmp)
dfs(0,0,0,0,[])
print(count)

