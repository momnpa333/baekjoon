#9:34->10:03
def solution(points, routes):
    history=[set()for _ in range(1000010)]
    answer=set()
    for route in routes:
        hist=move(points,route)
        for time,pos in enumerate(hist):
            if pos in history[time]:
                answer.add((pos,time))
            history[time].add(pos)
    return len(answer)

def move(points,route):
    hist=[]
    for cnt,item in enumerate(zip(route,route[1:])):
        S,E=item
        tmp=[]
        S=points[S-1];E=points[E-1]
        sr,sc=S; er,ec=E
        while True:
            tmp.append((sr,sc))

            if sr==er and sc==ec:
                break

            if sr>er:
                sr-=1
            elif sr<er:
                sr+=1
            else:   
                if sc>ec:
                    sc-=1
                elif sc<ec:
                    sc+=1
        if cnt>0:
            hist+=tmp[1:]
        else:
            hist+=tmp
    return hist
