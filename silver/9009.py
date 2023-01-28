import sys
input=sys.stdin.readline 

N=int(input())

dp=[0,1]
solv=[]
i=2
while True:
  dp.append(dp[i-1]+dp[i-2])
  if dp[i]>1000000000:
    break
  i+=1
for i in range(N):
  M=int(input())
  for j in range(len(dp)-1,-1,-1):
    if M==0:
      solv.reverse()
      print(*solv)
      solv=[]
      break
    if M-dp[j]>=0:
        M-=dp[j]
        solv.append(dp[j])