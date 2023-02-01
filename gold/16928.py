import sys
input=sys.stdin.readline

N,M=map(int,input().split())

up=[]
down=[]

for i in range(N):
    up.append(list(map(int,input().split())))
for j in range(M):
    down.append(list(map(int,input().split())))


queue=[1]
check=[0 for _ in range(121)]
count=0
flag=0
while True:
    L=len(queue)
    while L>0:
        tmp=queue.pop(0)
        for i in range(1,7):
            #사다리에 올라갈것 큐에 넣기
            for u in up:
                if (i+tmp)==u[0] and check[u[1]]==0:
                    if u[1]==100:
                        check[u[1]]=1
                        print(count+1)
                        flag=1
                        break
                    check[u[1]]=1
                    check[i+tmp]=1
                    queue.append(u[1])
            
            #뱀 큐에 넣기
            for d in down:
                if (i+tmp)==d[0] and check[i+tmp]==0:
                    if i+tmp==100:
                        check[i+tmp]
                        print(count+1)
                        flag = 1
                        break
                    check[i+tmp]=1
                    check[d[1]]=1
                    queue.append(d[1])
            else:
                if i+tmp==100:
                    flag = 1
                    print(count+1)
                    break
                if check[i+tmp]==0:
                    check[i+tmp]=1
                    queue.append(i+tmp)
            
            if(flag==1):
                break
        L-=1
        if(flag==1):
                break
    count+=1
    if(flag==1):
                break
