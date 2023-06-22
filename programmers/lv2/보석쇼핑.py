from collections import Counter
def solution(gems):
    st=set()
    for gem in gems:
        st.add(gem)
    st1=st.copy()
    start=0
    end=0
    answer=[]
    
    num=len(st1)
    st1=Counter()
    st1[gems[end]]+=1

                
    while True:
        if len(st1)==num:
            answer.append([end-start,start,end])
            st1[gems[start]]-=1
            if st1[gems[start]]==0:
                del st1[gems[start]]
            start+=1
        else:
            if end==(len(gems)-1):
                break
            end+=1
            st1[gems[end]]+=1
    
    answer=sorted(answer,key=lambda x:(x[0],x[1]))
    
    
    
    return [answer[0][1]+1,answer[0][2]+1]

