answer=0
history=[]
def hanoi4(n,s,v1,v2,e):
    global answer
    if n==1:
        answer+=1
        history.append([s,e])
        return
    if n==0:
        return
    hanoi(n-2,s,v1,v2)
    answer+=3
    history.append([s,v1])
    history.append([s,e])
    history.append([v1,e])
    hanoi4(n-2,v2,s,v1,e)
def hanoi(n,s,v,e):
    global answer
    if n==1:
        answer+=1
        history.append([s,e])
        return
    if n==0:
        return 
    hanoi(n-1,s,e,v)
    answer+=1
    history.append([s,e])
    hanoi(n-1,v,s,e)
N=int(input())
hanoi4(N,"A","B","C","D")
print(answer)
for i in history:
    print(*i)


