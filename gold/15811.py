# #10!=3628800
# from itertools import permutations
# A,B,C=input().split()

# alpha_list=list(set(map(str,A+B+C)))

# def trans_num(alpha_dic,st):
#     ret=0
#     cnt=len(st)-1
#     for s in st:
#         ret+=alpha_dic[s]*(10**cnt)
#         cnt-=1
#     return ret

# if len(alpha_list)>10:
#     print('NO')
#     exit(0)

# alpha_dic=dict()
# for item in permutations(range(10),min(10,len(alpha_list))):
#     alpha_dic={alpha:num for alpha,num in zip(alpha_list,item)}
#     NA=trans_num(alpha_dic,A);NB=trans_num(alpha_dic,B);NC=trans_num(alpha_dic,C)

#     if NA+NB==NC:
#         print('YES')
#         exit(0)

# print('NO')

from itertools import permutations
import sys


nums = [x for x in range(10)]
op1, op2, ans = map(list, sys.stdin.readline().split())


def solve():
    fir = sec = thi = 0
    for i in op1:
        fir *= 10
        fir += alnumDict[i]
    for i in op2:
        sec *= 10
        sec += alnumDict[i]
    for i in ans:
        thi *= 10
        thi += alnumDict[i]
    return thi == fir + sec


alphaList = sorted(list(set(op1 + op2 + ans)))

alnumDict = {}
alphaLength = len(alphaList)

for k in permutations(nums, alphaLength):
    if alphaLength > 10:
        break
    for i in range(alphaLength):
        alnumDict[alphaList[i]] = k[i]

    if solve():
        print("YES")
        exit(0)

print("NO")