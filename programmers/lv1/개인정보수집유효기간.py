def solution(today, terms, privacies):
    answer = []
    newtoday=list(map(int,today.split(".")))
    newterms={}
    print(newtoday)
    for term in terms:
        grade,date=term.split(" ")
        newterms[grade]=int(date)
    newpriv=[]
    for privacie in privacies:
        newpriv.append(privacie.split("."))
    for i in range(len(newpriv)):
        newpriv[i][1]=int(newpriv[i][1])+newterms[newpriv[i][2].split(" ")[1]]
        if newpriv[i][1]>12:
            while int(newpriv[i][1])>12:
                newpriv[i][0]=int(newpriv[i][0])+1
                newpriv[i][1]-=12

        newpriv[i][0]=int(newpriv[i][0])
        newpriv[i][1]=int(newpriv[i][1])
        newpriv[i][2]=int(newpriv[i][2].split(" ")[0])
    for i in range(len(newpriv)):
        if newpriv[i][0]<newtoday[0]:
            answer.append(i+1)
            continue
        if newpriv[i][0]==newtoday[0] and newpriv[i][1]<newtoday[1]:
            answer.append(i+1)
            continue
        if newpriv[i][0]==newtoday[0] and newpriv[i][1]==newtoday[1] and newpriv[i][2]<=newtoday[2]:
            answer.append(i+1)
        
    print(newpriv)

    return answer
