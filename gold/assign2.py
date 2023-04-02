origin=input('콤말 구분된 단어 3개 입력 >>')
change=origin.replace(' ','')
word1,word2,word3=change.split(',')
reverse=word1[::-1]
isReturn=reverse==word1
print('단어: {}, 역순: {}, 회문: {}'.format(word1,reverse,isReturn))
reverse=word2[::-1]
isReturn=reverse==word2
print('단어: {}, 역순: {}, 회문: {}'.format(word2,reverse,isReturn))
reverse=word3[::-1]
isReturn=reverse==word3
print('단어: {}, 역순: {}, 회문: {}'.format(word3,reverse,isReturn))