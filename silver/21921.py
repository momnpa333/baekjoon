from collections import Counter
N,X=map(int,input().split())
visited=list(map(int,input().split()))

left=0; right=X; answer=[]
total=sum(visited[:right])
answer.append(total)

while right<N:
    total-=visited[left]; total+=visited[right]
    left+=1; right+=1
    answer.append(total)
M=max(answer)
answer=Counter(answer)
if M==0:
    print("SAD")
    exit(0)
print(M)
print(answer[M])