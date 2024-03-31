from collections import defaultdict
import sys
input=sys.stdin.readline

T=int(input())

def find_parents(node,parents):
    if node==parents[node]:
        return node
    parents[node]=find_parents(parents[node],parents)
    return parents[node]

def union_node(a,b,parents,numbers):
    A=find_parents(a,parents)
    B=find_parents(b,parents)

    if A<B:
        parents[B]=A
        numbers[A]+=numbers[B]
        return A
    elif B<A:
        parents[A]=B
        numbers[B]+=numbers[A]
        return B
    else:
        return A



for _ in range(T):
    cnt=int(input())
    id=0
    ##parents 초기화
    
    names = defaultdict(int)
    parents=[0]*(cnt*2)
    numbers=[0]*(cnt*2)
    for i in range(cnt*2):
        parents[i]=i
    for _ in range(cnt):
        a,b=input().rstrip().split(' ')
        if a not in names:
            names[a]=id
            numbers[names[a]]=1
            id+=1
        if b not in names:
            names[b]=id
            numbers[names[b]]=1
            id+=1
        # print(numbers)
        target=union_node(names[a],names[b],parents,numbers)
        # print(numbers,names)
        answer=numbers[target]
        print(answer)
        # print(parents,names)



