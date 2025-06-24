N,K=map(int,input().split())

up=1;down=1

for i in range(N+K-1,N,-1):
    up*=i

for j in range(1,K):
    down*=j

print(up//down%1000000000)