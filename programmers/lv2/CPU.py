# #lev1
# print("             ")
# print(" [A]         ")
# print(" [B]         ")
# print("+---+---+---+")
# #lev2
# print("             ")
# print("             ")
# print(" [B] [A]     ")
# print("+---+---+---+")
# #lev3
# print("             ")
# print("             ")
# print("     [A] [B] ")
# print("+---+---+---+")
# #lev4
# print("             ")
# print("         [A] ")
# print("         [B] ")
# print("+---+---+---+")

B=[[]]
B[0]=list(map(str,"| |"))
B.append(list(map(str,"|B|")))
ary=[]
for i in range(6):
    ary.append(["-"]*13)

ary[0]=B
print(ary)

for i in ary:
    print(i)