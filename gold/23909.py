#1:41
# 둘 이상의 물고기가 같은 칸에 있을 수도 있으며, 마법사 상어와 물고기가 같은 칸에 있을 수도 있다.
# 물고기! 이동 방향은 8가지 방향(상하좌우, 대각선) 
# 상어는 현재 칸에서 상하좌우로 인접한 칸으로 이동할 수 있다

#1. 물고기 복제
#2. 모든 물고기가 한 칸 이동한다. 상어가 있는 칸, 물고기의 냄새가 있는 칸, 격자의 범위를 벗어나는 칸으로는 이동할 수 없다.
#3. 상어가 연속해서 3칸 이동한다. 가능한 이동 방법 중에서 제외되는 물고기의 수가 가장 많은 방법으로 이동하며, 그러한 방법이 여러가지인 경우 사전 순으로 가장 앞서는 방법을 이용한다
#4. 두 번 전 연습에서 생긴 물고기의 냄새가 격자에서 사라진다.
#5. 1에서 사용한 복제 마법이 완료된다. 모든 복제된 물고기는 1에서의 위치와 방향을 그대로 갖게 된다.
from collections import deque
import sys
input=sys.stdin.readline
fish_board=[[[] for _ in range(5)] for _ in range(5)]
smell_board=[[True]*5 for _ in range(5)]

M,S=map(int,input().split())
dir=[(0,-1),(-1,-1),(-1,0),(-1,1),(0,1),(1,1),(1,0),(1,-1)]
shark_dir=[(-1,0),(0,-1),(1,0),(0,1)]

for _ in range(M):
    r,c,d=map(int,input().split())
    d=(d-1)%8
    fish_board[r][c].append(d)

shark_r,shark_c=map(int,input().split())

smell=deque([])
smell.append(set());smell.append(set())

def copy_fish(fish_board,smell_board,smell):
    ret=[]
    for r in range(1,5):
        for c in range(1,5):
            for fish in fish_board[r][c]:
                ret.append((r,c,fish))

    for r,c in smell[-1]:
        smell_board[r][c]=False

    for r,c in smell[-2]:
        smell_board[r][c]=False

    return (ret,smell_board)

def move_fish(fish_board,smell_board,shark_r,shark_c):
    posi=[]
    for r in range(1,5):
        for c in range(1,5):
            for fish_dir in fish_board[r][c]:
                # 방향 바꾸기
                for d in range(8):
                    D=(fish_dir-d)%8
                    R=r+dir[D][0]; C=c+dir[D][1]
                    #냄새랑 상어 없으면 ㄱㄱ
                    if 0<R<5 and 0<C<5 and smell_board[R][C]==True and not (R==shark_r and C==shark_c):
                        posi.append((R,C,D))
                        break
                else:
                    posi.append((r,c,fish_dir))
    new_fish_board=[[[] for _ in range(5)] for _ in range(5)]

    for r,c,d in posi:
        new_fish_board[r][c].append(d)
    return new_fish_board

def move_shark(fish_board,smell,shark_r,shark_c):
    fish_cnt=0
    ans=(0,0,0,-1)
    for fir in range(4):
        firR=(shark_r+shark_dir[fir][0]); firC=(shark_c+shark_dir[fir][1])
        if 0<firR<5 and 0<firC<5:
            fish_cnt+=len(fish_board[firR][firC])
            fir_tmp=fish_board[firR][firC];fish_board[firR][firC]=[]
            for sec in range(4):
                secR=(firR+shark_dir[sec][0]); secC=(firC+shark_dir[sec][1])
                if 0<secR<5 and 0<secC<5:
                    fish_cnt+=len(fish_board[secR][secC])
                    sec_tmp=fish_board[secR][secC];fish_board[secR][secC]=[]
                    for th in range(4):
                        thR=(secR+shark_dir[th][0]); thC=(secC+shark_dir[th][1])
                        if 0<thR<5 and 0<thC<5:
                            fish_cnt+=len(fish_board[thR][thC])
                            th_tmp=fish_board[thR][thC];fish_board[thR][thC]=[]
                            if fish_cnt>ans[3]:
                                ans=(fir,sec,th,fish_cnt)
                            fish_board[thR][thC]=th_tmp
                            fish_cnt-=len(fish_board[thR][thC])
                    fish_board[secR][secC]=sec_tmp
                    fish_cnt-=len(fish_board[secR][secC])
            fish_board[firR][firC]=fir_tmp
            fish_cnt-=len(fish_board[firR][firC])
            

    smell_cur=set()
    # if len(fish_board[shark_r][shark_c])>0:
    #     smell_cur.add((shark_r,shark_c))
    # fish_board[shark_r][shark_c]=[]

    fir_posi_r=shark_r+shark_dir[ans[0]][0]; fir_posi_c=shark_c+shark_dir[ans[0]][1]

    if len(fish_board[fir_posi_r][fir_posi_c])>0:
        smell_cur.add((fir_posi_r,fir_posi_c))
    fish_board[fir_posi_r][fir_posi_c]=[]

    sec_posi_r=fir_posi_r+shark_dir[ans[1]][0]; sec_posi_c=fir_posi_c+shark_dir[ans[1]][1]

    if len(fish_board[sec_posi_r][sec_posi_c])>0:
        smell_cur.add((sec_posi_r,sec_posi_c))
    fish_board[sec_posi_r][sec_posi_c]=[]

    th_posi_r=sec_posi_r+shark_dir[ans[2]][0]; th_posi_c=sec_posi_c+shark_dir[ans[2]][1]; 

    if len(fish_board[th_posi_r][th_posi_c])>0:
        smell_cur.add((th_posi_r,th_posi_c))
    fish_board[th_posi_r][th_posi_c]=[]

    shark_r=th_posi_r
    shark_c=th_posi_c

    smell.append(smell_cur)


    return (shark_r,shark_c,smell,fish_board)

def remove_smell(smell_board,smell):
    remove_fish_set=smell.popleft()
    for r,c in remove_fish_set:
        smell_board[r][c]=True
    return smell_board

def input_fish(copy_ary,fish_board):
    for r,c,dir in copy_ary:
        fish_board[r][c].append(dir)
    return fish_board

for n in range(S):         
    copy_ary,smell_board=copy_fish(fish_board,smell_board,smell)
    fish_board=move_fish(fish_board,smell_board,shark_r,shark_c)
    # print(fish_board)
    shark_r,shark_c,smell,fish_board=move_shark(fish_board,smell,shark_r,shark_c)
    smell_board=remove_smell(smell_board,smell)
    fish_board=input_fish(copy_ary,fish_board)
    # print("!!!",fish_board,shark_r,shark_c)
    # print(smell_board)

    

answer=0
for r in range(1,5):
    for c in range(1,5):
        answer+=len(fish_board[r][c])

print(answer)



