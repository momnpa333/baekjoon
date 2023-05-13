menu=('주문 종료','올인원팩','투게더팩','트리오팩','패밀리팩')
price=(0,6000,7000,8000,10000)

total=0

while True:
    print('주문할 콤보 번호와 수량을 계속 입력하세요!')
    print('\t 0 주문 종료')
    for i in range(1,5):
        print('\t %d %s %5d원' %(i,menu[i],price[i]))
    order=input('>>')
    if order=='0':
        break
    ops,nums=order.split(' ')
    op=int(ops)
    num=int(nums)
    print('%s,%d개 주문'%(menu[op],num))
    total+=price[op]*num
    print('%s 주문 가격 %6d, 총 가격 %6d'%(menu[op],price[op]*num,total))

print('주문 종료'.center(20,'*'))
print('총 주문 가격 %d원'%(total))
print('주문을 마치겠습니다.')
print(' 안녕! '.center(20,'='))    

