N=int(input())
dots=[list(map(int,input().split(' '))) for _ in range(N)]
# print(dots)
dots.append(dots[0])
prod1=0; prod2=0

for a,b in zip(dots,dots[1:]):
    prod1+=a[0]*b[1]
for a,b in zip(dots,dots[1:]):
    prod2+=a[1]*b[0]

print(round(abs(prod1-prod2)/2,2))