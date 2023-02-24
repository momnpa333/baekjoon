import sys
input=sys.stdin.readline

a,b=map(int,input().split())

alpa=input().strip()
answer=''
for i in alpa:
    target=(ord(i)-ord('a'))
    target-=b
    while True:
        if target%a==0:
            break
        target+=26
    target//=a
    answer+=chr(target+ord('a'))
print(answer)