def solution(cap, n, deliveries, pickups):
    answer=0
    cur=n-1
    def service(cap,num):
        delivercap=cap
        pickcap=cap
        delivercur=num
        pickcur=num
        while delivercap>0 and delivercur>=0:
            if deliveries[delivercur]>0:
                delivercap-=1
                deliveries[delivercur]-=1
            if deliveries[delivercur]==0:
                delivercur-=1
        while pickcap>0 and pickcur>=0:
            if pickups[pickcur]>0:
                pickcap-=1
                pickups[pickcur]-=1
            if pickups[pickcur]==0:
                pickcur-=1
            
    while cur>=0:
        if deliveries[cur]!=0 or pickups[cur]!=0:
            service(cap,cur)
            answer+=(cur+1)*2
        if deliveries[cur]==0 and pickups[cur]==0:
            cur-=1
    return answer