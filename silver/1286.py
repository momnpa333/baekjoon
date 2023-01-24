import sys
input=sys.stdin.readline

N,M=map(int,input().split())
alpa=[input().strip()*2 for _ in range(N)]
# 2x2로 만들기
[alpa.append(alpa[i]) for i in range(N)]
R=N*2
C=M*2
width=0
height=0
answer=[0 for _ in range(26)]
for i in range(R):
    for j in range(C):
        #가로 경우의 수
        if  (j+1)>M:
            for k in range(C-j):
                width+=k+1
            width*=2
            width+=(M-(C-j))*2*(C-j)      
        else:
            for k in range(j+1):
                width+=k+1
            width*=2
            width+=(M-(j+1))*2*(j+1)
        #세로 경우의 수
        if (i+1)>N:
            for o in range(R-i):
                height+=o+1
            height*=2
            height+=(N-(R-i))*2*(R-i)
        else:
            for o in range(i+1):
                height+=o+1
            height*=2
            height+=(N-(i+1))*2*(i+1)
        answer[ord(alpa[i][j])-65]+=width*height
        width=0
        height=0
print(*answer)



