num=int(input())
stack=0
while True:
    str=input().strip()
    for i in str:
        if(i=='('):
            stack+=1
        elif(i==')'):
            stack-=1
        if (stack<0):
            print("NO")
            break
    else:
        if stack==0:
            print("YES")
        else:
            print("NO")
    num-=1
    stack=0
    if(num==0):
        break
