from collections import deque
import copy
board=[list(map(str,input()))for _ in range(12)]
# check=[[False]*5 for _ in range(12)]

def findbomb(r,c):
    # print(*check[-4::],sep="\n")
    dq=deque([])
    bombset=set()
    bombset.add((r,c))
    dq.append((r,c,board[r][c]))
    check[r][c]=True
    # print("!!!")
    while dq:
        for _ in range(len(dq)):
            curr,curc,item=dq.popleft()        
            # print(bombset)
            for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
                R=addr+curr; C=addc+curc
                if 0<=R<12 and 0<=C<6 and board[R][C]==item and check[R][C]==False:
                    dq.append((R,C,board[R][C]))
                    bombset.add((R,C))
                    check[R][C]=True
    if len(bombset)>=4:
        for r,c in bombset:
            board[r][c]="."
        return True
    return False


    

def gravity():
    newrow=[]
    ret=[]
    for row in zip(*board[::-1]):
        row=''.join(row)
        row=row.replace(".","")
        row=row+"."*(12-len(row))
        newrow.append(list(row)[::-1])
    for col in zip(*newrow[::-1]):
        ret.append(list(col[::-1]))
    return ret


answer=0
while True:
    flag=False
    op=False
    check=[[False]*6 for _ in range(12)]
    for r in range(12):
        for c in range(6):
            if board[r][c] != "." and check[r][c]==False:
                op=findbomb(r,c)
                if op==True:
                    # answer+=1
                    flag=True
    if flag==False:
        break
    else:
        # print("!")
        answer+=1
        board=gravity()
print(answer)

