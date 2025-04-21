nums=input()
start=0
L=len(nums)
if L%2==1:
    start=L-1
else:
    start=L

def isCri(st,length):
    if sum(map(int,map(str,st[:length//2])))==sum(map(int,map(str,st[length//2:]))):
        return True
    return False
    

for length in range(start,0,-2):
    for idx in range(L-length+1):
        if isCri(nums[idx:idx+length],length):
            print(length)
            exit(0)


