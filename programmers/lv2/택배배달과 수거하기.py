def solution(cap, n, deliveries, pickups):
    cur=n-1
    answer=0
    delicap=0
    pickcap=0
    for cur in range(n-1,-1,-1):
        if delicap>=deliveries[cur]:
            delicap-=deliveries[cur]
            deliveries[cur]=0
        else:
            deliveries[cur]-=delicap
            delicap=0
        if pickcap>=pickups[cur]:
            pickcap-=pickups[cur]
            pickups[cur]=0
        else:
            pickups[cur]-=pickcap
            pickcap=0
            
        while deliveries[cur]>0 or pickups[cur]>0:
            delicap+=cap
            pickcap+=cap
            if delicap>=deliveries[cur]:
                delicap-=deliveries[cur]
                deliveries[cur]=0
            else:
                deliveries[cur]-=delicap
                delicap=0
            if pickcap>=pickups[cur]:
                pickcap-=pickups[cur]
                pickups[cur]=0
            else:
                pickups[cur]-=pickcap
                pickcap=0
            answer+=(cur+1)
    return answer*2
            
            