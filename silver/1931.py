import sys
input=sys.stdin.readline

N=int(input())
ary=[list(map(int,input().split()))for _ in range(N)]
ary=sorted(ary,key=lambda x:(x[1],x[0]))
end=0
count=0
for i in ary:
    if end<=i[0]:end=i[1];count+=1
print(count)