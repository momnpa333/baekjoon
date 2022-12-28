#import sys
#input = sys.stdin.readline

n = int(input())
stringAry=input().strip()
sum=0
for i in range(n):
    sum+=int(stringAry[i])    
print(sum)

