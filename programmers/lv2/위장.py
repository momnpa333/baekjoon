
clothes=[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]


def solution(clothes):
    dict={}
    tmp=[]
    count=1
    for i in clothes:
        if dict.get(i[1],None):
            dict[i[1]]+=1
        else:
            dict[i[1]]=1
    for i in dict.items():
        count*=i[1]+1
    return count-1
    
print(solution(clothes))