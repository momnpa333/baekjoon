N=int(input())
M=int(input())
S=input()
answer=[]
solve=0
flag=0; prev=[]
for idx,s in enumerate(S):
    if flag==0:
        if s=="O":
            continue
        else:
            flag=1
            prev.append(s)
    elif flag==1:
        if s=="O" and prev[-1]=="I":
            prev.append(s)
        elif s=="I" and prev[-1]=="O":
            prev.append(s)
        elif s=="I" and prev[-1]=="I":
            answer.append(len(prev)//2)
            prev=[]
            prev.append("I")
        else:
            flag=0; answer.append((len(prev)-1)//2); prev=[]
else:
    answer.append((len(prev)-1)//2)
for ans in answer:
    solve+=max(0,ans-N+1)
print(solve)