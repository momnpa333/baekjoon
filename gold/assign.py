totalPrice=int(input('총 가격(원 가격) 입력>>'))

case1=(10000<=totalPrice<20000)*(0.99)
case2=(20000<=totalPrice<40000)*(0.98)
case3=(totalPrice>=40000)*0.96

print('원 가격:',totalPrice,' 할인된 가격:',totalPrice*(case1+case2+case3))
print('할인율: ',round(1-(case1+case2+case3),2),' 할인액:',round(totalPrice*(1-(case1+case2+case3)),2))
