import sys
from collections import Counter
input = sys.stdin.readline

words=[input().strip() for _ in range(int(input()))]

answer={}
solv={}
count=0
order=0
for i in range(len(words)):
    if(solv.get(words[i][0])):
        for j in solv[words[i][0]]:
                count=0
                for k in range(len(j) if len(j) < len(words[i]) else len(words[i])):
                        if j[k]==words[i][k]:
                            count+=1
                        elif j[k]!=words[i][k] :
                            if answer.get(j)==None:
                                order+=1
                                answer[j]=[[count,words[i]],order]
                                break
                            elif answer[j][0][0]<count:
                                answer[j][0]=[count,words[i]]
                                break
                else:
                    if answer.get(j)==None:
                                order+=1
                                answer[j]=[[count,words[i]],order]
                               
                    elif answer[j][0][0]<count:
                                answer[j][0]=[count,words[i]]
                                
        solv[words[i][0]].append(words[i])

    else:
        if(answer.get(words[i])==None):
            order+=1
            answer[words[i]]=[[0,None],order]
        solv[words[i][0]]=[words[i]]
sorting=sorted(answer.items(), key=lambda x:(-x[1][0][0],x[1][1]))

print(sorting[0][0])
print(sorting[0][1][0][1])
