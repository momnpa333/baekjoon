array=[1,5,2,6,3,7,4]
commands=[[2,5,3],[4,4,1],[1,7,3]]

def solution(array, commands):
    answer = []
    for command in commands:
        tmp=sorted(array[command[0]-1:command[1]])
        answer.append(tmp[command[2]-1])
    return answer
print(solution(array, commands))