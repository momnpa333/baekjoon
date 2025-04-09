import math

A,B=map(int,input().split())

D=math.gcd(A,B)

a=A//D; b=B//D
print(D)
print(a*b*D)