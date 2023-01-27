import sys
input = sys.stdin.readline

R,C=map(int,input().split())
map=[input().strip() for i in range(R)]
checkmap=[[0 for _ in range(C)]for _ in range(R)]

d_r=[0,1,0,-1]
d_c=[1,0,-1,0]
queue=[]
now_v=0
now_o=0
total_v=0
total_o=0
def bfs():
    global now_v
    global now_o
    global total_v
    global total_o
    global R
    global C
    while(len(queue)>0):
        pos=queue.pop()
        for i in range(4):
            if pos[0]+d_r[i]>=0 and pos[1]+d_c[i]>=0 and pos[0]+d_r[i]<R and pos[1]+d_c[i]<C:
                if map[pos[0]+d_r[i]][pos[1]+d_c[i]]!='#' and checkmap[pos[0]+d_r[i]][pos[1]+d_c[i]]==0:
                    checkmap[pos[0]+d_r[i]][pos[1]+d_c[i]]=-1
                    queue.append([pos[0]+d_r[i],pos[1]+d_c[i]])
                    if map[pos[0]+d_r[i]][pos[1]+d_c[i]]=='v':
                        now_v+=1
                    if map[pos[0]+d_r[i]][pos[1]+d_c[i]]=='k':
                        now_o+=1
    if now_v>=now_o:
        total_v+=now_v
        now_v=0 
        now_o=0
    else:
        total_o+=now_o
        now_v=0
        now_o=0
        
for i in range(R):
    for j in range(C):
        if map[i][j]!='#' and checkmap[i][j]==0:
            checkmap[i][j]=-1
            queue.append([i,j])
            if map[i][j]=='v':
                now_v+=1
            if map[i][j]=='k':
                now_o+=1
            bfs()
print(total_o,total_v)


