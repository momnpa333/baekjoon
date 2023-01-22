import sys
input = sys.stdin.readline

exam=input().strip().lower()

solv=[-1]*26
cnt=0
ary=list(exam)
for i in ary:
    if(solv[ord(i)-97]==-1):
        solv[ord(i)-97]=cnt
    cnt+=1
for i in solv:
    print(i,end=' ')