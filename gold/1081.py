import math
def make_dict():
    num_dict=dict()
    num_dict[0]=0
    num_dict[1]=45

    for n in range(2,10):
        num_dict[n]=sum_nine(n,num_dict)
    return num_dict


def sum_nine(n,num_dict):
    return num_dict[n-1]*10+num_dict[1]*10**(n-1)

def find_sum(num,num_dict):
    L=len(num)
    ret=0

    for idx,n in enumerate(num):
        for i in range(int(n)):
            ret+=num_dict[L-idx-1]
            ret+=i*(10**(L-idx-1))
        else:
            if idx<L-1:
                ret+=int(num[idx])*(int(num[idx+1:])+1)
    ret+=int(num[-1])
    return ret
    
L,U=input().split()
num_dict=make_dict()
if L!='0':
    L=str(int(L)-1)
L=find_sum(L,num_dict)
U=find_sum(U,num_dict)
print(U-L)