# 1:1 2:2 3:3 4:4
# 10:9+2 11:9+4
# 50: 9+2*41

krii=input()

L=len(krii); cnt=0
if L>9:
    cnt=(L-9)//2+9
else:
    cnt=L

check=set()
check.add(0)
answer=[]

def dfs(answer,check,idx):
    if len(check)==cnt+1:
        print(*answer)
        exit(0)

    if int(krii[idx]) not in check:
        check.add(int(krii[idx]))
        answer.append(int(krii[idx]))
        dfs(answer,check,idx+1)
        check.remove(int(krii[idx]))
        answer.pop()

    if idx+1<=len(krii) and int(krii[idx])!=0 and int(krii[idx]+krii[idx+1])<=cnt and int(krii[idx]+krii[idx+1]) not in check:
        check.add(int(krii[idx]+krii[idx+1]))
        answer.append(int(krii[idx]+krii[idx+1]))
        dfs(answer,check,idx+2)
        check.remove(int(krii[idx]+krii[idx+1]))
        answer.pop()

dfs(answer,check,0)