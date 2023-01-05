cipher="pfqallllabwaoclk"
code=2

def solution(cipher, code):
    answer=[]
    for i in range(0,len(cipher)):
        if i%code==code-1:
            answer.append(cipher[i])
    return ''.join(answer)

print(solution(cipher, code))