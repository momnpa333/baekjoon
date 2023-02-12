import sys
input=sys.stdin.readline
N,M,row,col,K=map(int,input().split())

MAP=[]
for i in range(N):
    MAP.append(list(map(int,input().split())))

L=0;R=0;U=0;D=0;top=0;bottom=0
cmd=list(map(int,input().split()))

for i in range(K):
    if cmd[i]==1:
        if 0<=col+1<M:
            tmp=top;top=L;L=bottom;bottom=R;R=tmp
            col+=1
        else:
            continue
    elif cmd[i]==2:
        if 0<=col-1<M:
            tmp=top;top=R;R=bottom;bottom=L;L=tmp
            col-=1
        else:
            continue
    elif cmd[i]==3:
        if 0<=row-1<N:
            tmp=top;top=D;D=bottom;bottom=U;U=tmp
            row-=1
        else:
            continue    
    elif cmd[i]==4:
        if 0<=row+1<N:
            tmp=top;top=U;U=bottom;bottom=D;D=tmp
            row+=1
        else:
            continue
    if MAP[row][col]==0:
        MAP[row][col]=bottom
    else:
        bottom=MAP[row][col]
        MAP[row][col]=0

    print(top)

