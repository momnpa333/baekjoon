people=[80,70,50]
limit=100
def solution(people, limit):
    people=sorted(people)
    front=0
    back=len(people)-1
    count=0

    while True:
        if front>back:
            break
        if front==back:
            count+=1
            break

        if people[front]+people[back]<=limit:
            count+=1
            front+=1
            back-=1
        else:
            count+=1
            back-=1
    else:
        print('???')
    return count
print(solution(people,limit))