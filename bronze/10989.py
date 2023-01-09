import sys
input = sys.stdin.readline

solv=[0]*10001


for _ in range(int(input())):
    solv[int(input())]+=1
    
for i in range(10001):
    if(solv[i] != 0):
        for j in range(solv[i]):
            print(i)