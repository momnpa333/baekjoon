import sys
input=sys.stdin.readline
R,C=map(int,input().split())

board=[input().rstrip() for _ in range(R)]
answer_list=[]

for col in zip(*board):
    words=''.join(col).split("#")
    for word in words:
        if len(word)>1:
            answer_list.append(word)

for row in board:
    words=''.join(row).split("#")
    for word in words:
        if len(word)>1:
            answer_list.append(word)
answer_list=sorted(answer_list)
# print(answer_list)
print(answer_list[0])


