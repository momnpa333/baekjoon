people=[80,70,60,50,50]
[80+20,70+30,50+50,10+10+10]
limit=120
def solution(people, limit):
    people=sorted(people)
    weight=[]
    
    for person in people:
        for i in range(len(weight)):
            
            if weight[i][0]+person<=limit and weight[i][1]<2:
                weight[i][0]+=person
                answer+=1
                break
        else:
            weight.append([person,1])
    return len(weight)
print(solution(people,limit))