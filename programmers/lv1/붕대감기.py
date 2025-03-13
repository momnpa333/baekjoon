def solution(bandage, health, attacks):
    maxHealth=health
    cooltime,secHeal,addHeal=bandage
    curTime=0
    for time,damage in attacks:
        total=((time-1-curTime)//cooltime)*addHeal+secHeal*(time-1-curTime)
        health=min(health+total,maxHealth)
        health=max(0,health-damage)
        if health==0:
            return -1
        curTime=time
    return health