import sys
from itertools import combinations_with_replacement
input=sys.stdin.readline

N=int(input())

numary=sorted([int(input()) for _ in range(N)])
rear=len(numary)-1

left=0
right=rear-1
flag=0
mid=(left+right)//2
front=left
back=right
while rear>0:
    while left<right:
        while front<back:
            #정답을 맞췄을때
            #left와 right가 만날떄 까지 반복
            if numary[left]+numary[right]+numary[mid]==numary[rear]:
                print(numary[rear])
                flag=1
                break
            #left+mid+rigth>rear 일때
            if numary[left]+numary[right]+numary[mid]>numary[rear]:
                #mid값을 작은쪽으로 내리자
                if mid==back and front==back-1:
                    mid=front
                    back=front
                back=mid
                mid=(front+back)//2
            #left+mid+rigth<rear 일때
            elif numary[left]+numary[right]+numary[mid]<numary[rear]:
                #mid값을 큰쪽으로 올리자
                if mid==front and front==back-1:
                    mid=back
                    front=back
                front=mid
                mid=(front+back+1)//2
        #반복문이 끝나고 left와 right가 만났을때 마지막 비교
        #반복문이 끝난후 left와 right 조정
        else:
            if numary[left]+numary[right]+numary[mid]==numary[rear]:
                print(numary[rear])
                flag=1
                break
            #mid가 작은쪽에 치우쳐있다면 right를 빼서 조사값이 작게 만들자
            if mid<(left+right)//2:
                right-=1
            else:
                left+=1
            front=left
            back=right
            mid=(left+right)//2
        if flag==1:
            break
    else:
        if numary[left]+numary[right]+numary[mid]==numary[rear]:
            print(numary[rear])
            flag=1
            break
        rear-=1
        left=0
        right=rear-1
        front=0
        back=right
        mid=(left+right)//2
    if flag==1:
            break

        
        
