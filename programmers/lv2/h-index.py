citations=[3,0,6,1,5]
# 1 1 4 4 5 5 5 11 
def solution(citations):
    citations=sorted(citations)
    #홀수라면
    if len(citations)%2==1:
        if citations[int(len(citations)/2)]==len(citations)//2+1:
            return len(citations)//2+1
        else: return 0
    #짝수라면
    else:
        if citations[int(len(citations)/2)-1]<=int(len(citations)/2) and citations[int(len(citations)/2)]>=int(len(citations)/2):
            return int(len(citations)/2)



print(solution(citations))