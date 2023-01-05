n=12345

def solution(n):
    stringN=str(n)
    list(reversed(stringN))
    return list(map(int,(list(reversed(stringN)))))
print(solution(n))