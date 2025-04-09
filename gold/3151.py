N=int(input())
members=sorted(list(map(int,input().split())))
answer=0

def find_team(left,right,tar):
    ret=0
    while left<right:
        # print(members[left],members[right],tar)
        if members[left]+members[right]>tar:
            right-=1
        elif members[left]+members[right]<tar:
            left+=1
        else:
            left_cnt=1;right_cnt=1
            if members[left]!=members[right]:
                while members[left+1]==members[left]:
                    left_cnt+=1
                    left+=1
                while members[right-1]==members[right]:
                    right_cnt+=1
                    right-=1
                left+=1; right-=1
                ret+=left_cnt*right_cnt
            else:
                ret+=(right-left+1)*(right-left)//2
                break
    return ret
    
# print(members)
for i in range(N-2):
    answer+=find_team(i+1,N-1,-members[i])
    
print(answer)