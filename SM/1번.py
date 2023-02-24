import sys
input=sys.stdin.readline
N=int(input())
keyword=set()
for i in range(4):
    keyword.add(input())

def include(word,find):
    if len(word)>len(find):
        return False
    for i in range(len(word)):
        if word[i]!=find[i]:
            return False
    return True

T=int(input())

for i in range(T):
    count=0
    word=input().strip()
    for key in keyword:
        if include(word,key)==True:
            count+=1
    print(count)

