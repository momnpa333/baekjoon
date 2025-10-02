# from collections import defaultdict

def solution(commands):
    answer = []
    # print(commands)
    board,parents=init()
    
    for command in commands:
        com=command.split(" ")
        
        if com[0]=="UPDATE":
            if len(com)==4:
                update1(int(com[1]),int(com[2]),com[3],board,parents)
        if com[0]=="UPDATE":
            if len(com)==3:
                update2(com[1],com[2],board)
        if com[0]=="MERGE":
            merge(int(com[1]),int(com[2]),int(com[3]),int(com[4]),board,parents)
        if com[0]=="UNMERGE":
            unmerge(int(com[1]),int(com[2]),board,parents)
        if com[0]=="PRINT":
            answer.append(print_board(int(com[1]),int(com[2]),board,parents))
    # print(parents)
    return answer
def init():
    board=[[""for _ in range(51)] for _ in range(51)]
    parents=[[[]for _ in range(51)] for _ in range(51)]
    for r in range(51):
        for c in range(51):
            parents[r][c].append([r,c])
            parents[r][c].append([])
            parents[r][c][1].append([r,c])
            
    return board,parents

def update1(r,c,value,board,parents):
    R,C=find_parents([r,c],parents)
    board[R][C]=value
def update2(value1,value2,board):
    for r in range(51):
        for c in range(51):
            if board[r][c]==value1:
                board[r][c]=value2
                
def merge(r1,c1,r2,c2,board,parents):
    R1,C1=find_parents([r1,c1],parents)
    R2,C2=find_parents([r2,c2],parents)
    if (R1,C1)==(R2,C2):
        return
    if board[R1][C1]:
        parents[R2][C2][0]=[R1,C1]
        parents[R1][C1][1]+=parents[R2][C2][1]
        return 
    
    if board[R2][C2]:
        parents[R1][C1][0]=[R2,C2]
        parents[R2][C2][1]+=parents[R1][C1][1]
        return
    else:
        parents[R1][C1][0]=[R2,C2]
        parents[R2][C2][1]+=parents[R1][C1][1]
        return
        
    
def find_parents(node,parents):
    r,c=node
    if node==parents[r][c][0]:
        return parents[r][c][0]
    parents[r][c][0]=find_parents(parents[r][c][0],parents)
    return parents[r][c][0]


def print_board(r,c,board,parents):
    R,C=find_parents([r,c],parents)
    if board[R][C]:
        return board[R][C]
    else:
        return "EMPTY"
def unmerge(r,c,board,parents):
    # for p in parents:
    #     print(p)
    # print(board)
    R,C=find_parents([r,c],parents)
    value=board[R][C]
    for child_r,child_c in parents[R][C][1]:
        parents[child_r][child_c][0]=[child_r,child_c]
        parents[child_r][child_c][1]=[[child_r,child_c]]
        board[child_r][child_c]=""
    # print("!!")
    # for p in parents:
    #     print(p)
    board[r][c]=value
    # print(board)
    
    