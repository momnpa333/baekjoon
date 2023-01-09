phone_number="027778889"

def solution(phone_number):
    numberlen=len(phone_number)-4
    answer='*'*numberlen
    answer=answer+phone_number[-4:]
    return answer
    
print(solution(phone_number))