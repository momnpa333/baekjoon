import sys
input=sys.stdin.readline
N,M=map(int,input().split())
N_ary=list(map(int,input().split()))
[N_ary.append(i) for i in list(map(int,input().split()))]
print(*sorted(N_ary))
