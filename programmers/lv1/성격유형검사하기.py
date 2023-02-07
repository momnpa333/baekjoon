def solution(survey, choices):
    answer=''
    score={}
    score['A']=0;score['N']=0;score['C']=0;score['F']=0;score['M']=0;score['J']=0;score['R']=0;score['T']=0
    for i,choice in zip(survey,choices):
        if (choice-4)>0:
            score[i[1]]+=choice-4
        else:
            score[i[0]]+=-1*(choice-4)
    
    if score['T']<=score['R']:
        answer+='R'
    else:
        answer+='T'
    if score['F']<=score['C']:
        answer+='C'
    else:
        answer+='F'
    if score['M']<=score['J']:
        answer+='J'
    else:
        answer+='M'
    if score['N']<=score['A']:
        answer+='A'
    else:
        answer+='N'
    print(score)
    return answer