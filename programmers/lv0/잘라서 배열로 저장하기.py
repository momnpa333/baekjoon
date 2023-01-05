my_str="abc1Addfggg4556b"
n=6
def solution(my_str, n):
    answer=[]
    tmp=1
    while(True):
        if n*(tmp-1)>=len(my_str): 
            break
        answer.append(my_str[n*(tmp-1):n*tmp])
        tmp+=1
    return answer
print(solution(my_str,n))