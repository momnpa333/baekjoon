# 물은 다음과 같이 재분배 한다.

# 먼저 같은 양의 물이 들어있는 물병 두 개를 고른다.
# 그 다음에 한 개의 물병에 다른 한 쪽에 있는 물을 모두 붓는다.
# 이 방법을 필요한 만큼 계속 한다.

N,K=map(int,input().split(" "))
bottle_type=[]
def make_two():
    num=1
    while num<N*2:
        bottle_type.append(num)
        num*=2
make_two()

def solve(N,K):
    num=-1
    while K>0 and N>0:
        if N>=bottle_type[num]:
            N-=bottle_type[num]
            K-=1
        else:
            num-=1
        # print(num,N)
    if N>0:
        return bottle_type[num]-N
    return 0

# print(bottle_type)
print(solve(N,K))
