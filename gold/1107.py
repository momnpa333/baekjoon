import sys
input = sys.stdin.readline

numAryP=int(input())
numAryM=numAryP
cnt=0
M=int(input())
broken=set()
if M!=0:
    broken=set(map(int,input().split()))

def isPosi(num):
    listA=list(map(int,str(num)))
    for i in listA:
        if i in broken:
            return False
    else:
        return True


while True:
    if numAryP==100 or numAryM==100:
        print(cnt-1)
        exit(0)
    if isPosi(numAryP)==True:
        t=cnt+len(list(map(int,str(numAryP))))
        if t<abs(numAryP-100):
            print(t)
        else:
            print(abs(numAryP-100))
        exit(0)
    if 0<=numAryM and isPosi(numAryM)==True:
        t=cnt+len(list(map(int,str(numAryM))))
        if t<abs(numAryM-100):
            print(t)
        else:
            print(abs(numAryM-100))
        exit(0)
    numAryP+=1
    numAryM-=1
    cnt+=1





    
    



    





