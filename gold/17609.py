T=int(input())
items=[input() for _ in range(T)]
# print(items)

def iszero(item):
    left=0; right=len(item)-1
    while left<right:
        if item[left]==item[right]:
            left+=1; right-=1
        else:
            return False
    return True

def isone(item):
    left=0; right=len(item)-1
    flag=0
    while left<right:
        if item[left]==item[right]:
            left+=1; right-=1
        else:
            if flag==0:
                flag+=1
                left+=1
            else:
                break
    else:
        if item[left]==item[right]:
            return True
        else:
            if flag==1:
                return True
    left=0; right=len(item)-1
    flag=0
    while left<right:
        if item[left]==item[right]:
            left+=1; right-=1
        else:
            if flag==0:
                flag+=1
                right-=1
            else:
                break
    else:
        if item[left]==item[right]:
            return True
        else:
            if flag==1:
                return True
    return False
answer=[]
for item in items:
    if iszero(item):
        answer.append(0)
    elif isone(item):
        answer.append(1)
    else:
        answer.append(2)
for i in answer:
    print(i)