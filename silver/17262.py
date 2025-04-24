import sys
input=sys.stdin.readline
N=int(input())

S=0; E=float('inf')

for _ in range(N):
    s,e=map(int,input().split())
    S=max(S,s); E=min(E,e)
print(max(0,S-E))
