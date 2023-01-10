import math
num=3
total=12

def solution(num, total):
    answer=[]
    [ answer.append(i) for i in range(math.floor(total/num-num/2+1/2),math.floor(total/num-num/2+1/2)+num)]
    print(answer)
    return answer
solution(num,total)