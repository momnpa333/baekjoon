def solution(id_list, report, k):
    answer={}
    answer1=[]
    reportAry={}
    reportNum={}
    for id in id_list:
        reportAry[id]=[]
        reportNum[id]=0
        answer[id]=0
        
    for tmp in report:
        A,B=tmp.split()
        for i in reportAry[A]:
            if i==B:
                break
        else: 
            reportNum[B]+=1
            reportAry[A].append(B)


    for i in id_list:
        if reportNum[i]>=k:
            for id1 in id_list:
                for report in reportAry[id1]:
                    if report==i:
                        answer[id1]+=1
                        break
                        
    for i in id_list:
        answer1.append(answer[i])
    
    return answer1