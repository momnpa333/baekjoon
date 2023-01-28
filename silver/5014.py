import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)
F,S,G,U,D=map(int,input().split())
queue=[]
check=[0 for _ in range(F+2)]
queue.append(S)
depth=1
answer=-1
if S==G:
    print(0)
else:
    while len(queue)>0:
        N=len(queue)
        while N>0:
            now=queue.pop(0)
            if now+U==G or now-D==G:
                print(depth)
                answer=0
                break
            if now+U<=F and check[now+U]==0:
                check[now+U]=1
                queue.append(now+U)
            if now-D>0 and check[now-D]==0:
                check[now-D]=1
                queue.append(now-D)
            N-=1
        depth+=1
        if answer==0:
            break
    if answer==-1:
        print('use the stairs')

 
