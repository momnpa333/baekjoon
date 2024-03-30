clocks=[]
for i in range(4):
    clocks.append(input())

K=int(input())

def move(num,dir):
    for i in (-1,1):
        if 0<=num+i<4 and num+i not in check:
            if i==-1:
                if clocks[num][6]!=clocks[num+i][2]: 
                    check.add(num+i)
                    move(num+i,-1*dir)
            else:
                if clocks[num][2]!=clocks[num+i][6]: 
                    check.add(num+i)
                    move(num+i,-1*dir)
    if dir==1:
        clocks[num]=clocks[num][-1]+clocks[num][:7]
    else:
        clocks[num]=clocks[num][1:]+clocks[num][0]


for _ in range(K):
    target,dir=map(int,input().split(' '))
    check=set()
    check.add(target-1)
    move(target-1,dir)
# print(clocks)
answer=0
for idx,clock in enumerate(clocks):
    answer+=int(clock[0])*(2**idx)
print(answer)