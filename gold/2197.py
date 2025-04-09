import sys
input=sys.stdin.readline
N=int(input())

def prefix(st1,st2):
    ret=0
    for s1,s2 in zip(st1,st2):
        if s1==s2:
            ret+=1
        else:
            return ret
    return ret

inputs=[(input().rstrip(),i) for i in range(N)]
idx=0; answer=[set()for _ in range(101)]; maxLength=-1
words=sorted(inputs)
for a,b in zip(words,words[1:]):
    length=prefix(a[0],b[0])
    if length>maxLength:
        maxLength=length
    answer[length].add(a[0][:length])

if maxLength==0:
    print(inputs[0][0])
    print(inputs[1][0])
    exit(0)

target="!"
for item in inputs:
    if len(item[0])>=maxLength and target=="!":
        if item[0][:maxLength] in answer[maxLength]:
            print(item[0])
            target=item[0][:maxLength]
    else:
        if item[0].startswith(target):
            print(item[0])
            exit(0)
    
