strings=[]
strings=["aacce", "abcccd", "abcdx"]
n=2

def solution(strings, n):
    answer = []

    for i in range(len(strings)-1,0,-1): 
        for j in range(i): 
            if strings[j][n]==strings[j+1][n]:
                if strings[j]>strings[j+1]:
                     strings[j],strings[j+1] = strings[j+1],strings[j]
            if strings[j][n]>strings[j+1][n]:
                strings[j],strings[j+1] = strings[j+1],strings[j]
    return strings

print(solution(strings, n))