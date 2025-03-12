import sys
from collections import deque
input=sys.stdin.readline
R,C=map(int,input().split())
board=[list(map(str,input().rstrip()))for _ in range(R)]
N=int(input())
bomb=list(map(int,input().split()))
bomb=[R-item for item in bomb]

dq=deque([])

for i in range(len(bomb)):
    flag=True
    if i%2==0:
        for bombc in range(C):
            if board[bomb[i]][bombc]=="x":
                board[bomb[i]][bombc]='.'
                break
    else:
        for bombc in range(C-1,-1,-1):
            if board[bomb[i]][bombc]=="x":
                board[bomb[i]][bombc]='.'
                break
    check=[[True]*C for _ in range(R)]
    # cluster=[]
    for r in range(R):
        for c in range(C):
            if check[r][c]==True and board[r][c]=="x":
                clusterSet=set();positionDict=dict()
                dq.append((r,c)); check[r][c]=False; clusterSet.add((r,c))
                while dq:
                    for _ in range(len(dq)):
                        curr,curc=dq.popleft()
                        for addr,addc in ((0,1),(1,0),(0,-1),(-1,0)):
                            RR=curr+addr; CC=curc+addc
                            if 0<=RR<R and 0<=CC<C and board[RR][CC]=='x'and check[RR][CC]==True:
                                dq.append((RR,CC));clusterSet.add((RR,CC));check[RR][CC]=False
                # cluster.append(clusterSet)
                # print(clusterSet)
                for itemr,itemc in clusterSet:
                    if itemc in positionDict:
                        positionDict[itemc]=max(itemr,positionDict[itemc])
                    else:
                        positionDict[itemc]=itemr
                target=float('inf')
                if max(positionDict.values())==R-1:
                    continue
                else:
                    flag=False
                    #떨어진 간격 구하기
                    for itemc,itemr in positionDict.items():
                        height=itemr+1
                        while height<R:
                            if board[height][itemc]=="x":
                                # print("!",height,itemc)
                                break
                            height+=1
                        target=min(target,height-itemr)
                # print("!",positionDict)
                # print("!",target)
                # print("!",clusterSet)
                for itemr,itemc in clusterSet:
                    board[itemr][itemc]="."
                for itemr,itemc in clusterSet:
                    board[itemr+target-1][itemc]="x"
                break
        if flag==False:
                break
                # print(clusterSet,positionDict,target)
for item in board:
    print(''.join(item))







