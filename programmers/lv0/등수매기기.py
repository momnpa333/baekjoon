score =[[80, 70], [70, 80], [30, 50], [90, 100], [100, 90], [100, 100], [10, 30]]
def solution(score):
    answer = []
    seq=[]
    tmp=1
    for i in score:
        answer.append(i[0]+i[1])
    for i in answer:
        for j in answer:
            if i<j: 
                tmp+=1
        seq.append(tmp)
        tmp=1
    return seq
print(solution(score))