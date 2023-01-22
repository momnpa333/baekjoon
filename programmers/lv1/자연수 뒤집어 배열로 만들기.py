n=12345

def solution(n):
    stringN=str(n)
    return list(map(int,(list(reversed(stringN)))))
print(solution(n))