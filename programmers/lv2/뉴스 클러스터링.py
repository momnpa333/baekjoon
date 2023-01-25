str1='E=M*C^2'
str2='e=m*c^2'

def solution(str1, str2):
    
    newStr1=[]
    newStr2=[]
    str1=str1.upper()
    str2=str2.upper()
    for i in range(len(str1)-1):
        if (65<=ord(str1[i])and ord(str1[i])<=90 and 65<=ord(str1[i+1])and ord(str1[i+1])<=90):
            newStr1.append(str1[i]+str1[i+1])

    for i in range(len(str2)-1):
        if (65<=ord(str2[i])and ord(str2[i])<=90 and 65<=ord(str2[i+1])and ord(str2[i+1])<=90):
            newStr2.append(str2[i]+str2[i+1])

    Subset=[]
    Union=[]      
    tmp1=newStr2.copy()
    tmp2=newStr2.copy()  
    for i in newStr1:
        if i not in tmp1:
            tmp2.append(i)
        else:
            tmp1.remove(i)
    Union=tmp2

    for i in newStr2:
        if i in newStr1:
            newStr1.remove(i)
            Subset.append(i)
    if(len(Union)==0):
        return 65536

    return int((len(Subset))/(len(Union))*65536)

print(solution(str1, str2))