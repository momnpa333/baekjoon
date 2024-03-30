from collections import deque
import sys
input=sys.stdin.readline
T=int(input().rstrip())

def makestr(items):
    ret=""
    for i in items:
        ret+=str(i)+" " 
    return ret.rstrip()
def diffnum(items,target):
    ret=0
    for a,b in zip(items,target):
        if a!=b:
            ret+=1
    return ret
def sadari(N,target):
    dq=deque([])
    check=set()
    items=[i+1 for i in range(N)]
    tar=makestr(target)
    check.add(makestr(items))
    if target==items:
        return 0
    
    for i in range(N-1):
        if items[i]!=target[i]:
            newitems=items[:i]+[items[i+1]]+[items[i]]+items[i+2:]
            newitems=makestr(newitems)
            if tar==newitems:
                return 1
            check.add(newitems)
            diff=diffnum(newitems,tar)
            dq.append((1,newitems,diff))
    while dq:
        # print(dq)
        for _ in range(len(dq)):
            cnt,items,diff=dq.popleft()
            items=list(items.split(" "))
            for i in range(N-1):        
                if items[i]!=target[i]:
                    newitems=items[:i]+[items[i+1]]+[items[i]]+items[i+2:]
                    newitems=makestr(newitems)
                    # print(newitems,tar)
                    if newitems==tar:
                        return cnt+1
                    if newitems not in check:
                        newdiff=diffnum(newitems,tar)
                        if newdiff<=diff:
                            dq.append((cnt+1,newitems,newdiff))
                            check.add(newitems)
    return cnt

# def sadari(N,target):
#     items=[i+1 for i in range(N)]
#     for i in range(N):
#         if items[i] 

for _ in range(T):
    N=int(input().rstrip())
    items=list(map(int,input().rstrip().split(' ')))
    print(sadari(N,items))