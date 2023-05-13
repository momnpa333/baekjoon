from random import choice
dcs={'가위':'보오','바위':'가위','보오':'바위'}
tit=['철수','영희']
rsp=('가위','바위','보오')

print(''.center(18,'*'))
print('%s %4s   승자'%(tit[0],tit[1]))
print(''.center(18,'*'))
for i in range(10):
    case1=(choice(rsp))
    case2=(choice(rsp))
    if dcs[case1]==case2:
        winner=tit[0]
    elif dcs[case2]==case1:
        winner=tit[1]
    else:
        winner='없음'
    print('%s %4s %4s'%(case1,case2,winner))
