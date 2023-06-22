import sys
input=sys.stdin.readline

ary=input().rstrip().replace(",","").replace(";","").split(" ")

mod=ary[0]
ary.pop(0)

for var in ary:
    tmp=""
    alp=""
    var=var[::-1]
    for i in var:
        if i.isalpha()==False:
            if i=="[":
                tmp+="]"
            elif i =="]":
                tmp+="["
            else:
                tmp+=i
        else:
            alp+=i
    alp=" "+alp[::-1]
    print(mod+tmp+alp+";")

    