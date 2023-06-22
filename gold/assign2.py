import numpy as np
answer=[]
a=np.arange(0,16).reshape(4,4)
b=a[:,1]
c=a[2,1:4]
d=a[:2,:2]
e=a[1:3,1:3]
f=a[:2,:3].flatten()
g=a[2:4,:4].flatten()
h=a[1:4:2,1:4].flatten()

answer.append(b);answer.append(c);answer.append(d);answer.append(e);answer.append(f);answer.append(g);answer.append(h)

for i in range(7):
    print('%c ='%(i+ord('b')),end="")
    print(answer[i])