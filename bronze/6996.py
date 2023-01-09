import sys
input = sys.stdin.readline

strList=[list(map(str,input().split())) for _ in range(int(input()))]

sol=''
for i in strList:
    a=''.join(sorted(i[0]))
    b=''.join(sorted(i[1]))
    if a==b:
        sol=i[0]+' & '+i[1]+' are anagrames.'
        print(sol)
    else:
        sol=i[0]+' & '+i[1]+' are NOT anagrames.'
        print(sol)
