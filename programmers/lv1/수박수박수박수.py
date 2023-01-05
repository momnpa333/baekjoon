n=3
def solution(n):
    answer = []
    for i in range(n):
        if i%2==0:
            answer.append('수')
        if i%2==1:
            answer.append('박')
        
    return ''.join(answer)

print(solution(n))