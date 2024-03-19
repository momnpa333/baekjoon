from itertools import combinations

L,C=map(int,input().split(' '))
alpa=input().split(' ')
alpa=sorted(alpa)
op1=['a','e','i','o','u']
op2=list(str('bcdfghjklmnpqrstvwxyz'))

def isposi(item):
    cnt1=0;cnt2=0
    for i in item:
        if i in op1:
            cnt1+=1
        else:
            cnt2+=1
    if cnt1>=1 and cnt2>=2:
        return True
    return False

for i in combinations(alpa,L):
    if isposi(i):
        print(''.join(i))


