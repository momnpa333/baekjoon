my_string="Bcad"

def solution(my_string):
    answer =''.join(sorted(my_string.lower()))
    return answer

print(solution(my_string))
