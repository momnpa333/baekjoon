m=10
n=10
startX=3
startY=7
balls=[[7, 7], [2, 7], [7, 3]]
#[52, 37, 116]
def solution(m, n, startX, startY, balls):
    answer = []
    def fourPos(posX,posY):
        origin=[(-posX,posY),(posX,-posY),((2*m)-posX,posY),(posX,2*n-posY)]
        if posY==startY:
            if posX<startX:
                origin.pop(0)
            elif posX>startX:
                origin.pop(2)
        if posX==startX:
            if posY<startY:
                origin.pop(1)
            elif posY>startY:
                origin.pop(3)
        return origin
    for ball in balls:
        min=987654321
        for i in fourPos(ball[0],ball[1]):
            tmp=(startX-i[0])**2+(startY-i[1])**2
            if tmp<min:
                min = tmp
        else:
            answer.append(min)
    print(answer)
    return answer
solution(m, n, startX, startY, balls)