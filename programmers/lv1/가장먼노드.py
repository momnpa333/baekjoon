from collections import deque
def solution(n, edge):
    answer = 0
    check=[0]*(n+1)
    dq=deque([])
    nodes=[[]for i in range(n+1)]
    for e in edge:
        nodes[e[0]].append(e[1])
        nodes[e[1]].append(e[0])
    dq.append(1)
    check[1]=1
    cnt=1
    while dq:
        cnt+=1
        T=len(dq)
        while T>0:
            tmp=dq.popleft()
            for node in nodes[tmp]:
                if check[node]==0:
                    check[node]=cnt
                    dq.append(node)
            T-=1
    for i in range(n+1):
        if check[i]==max(check):
            answer+=1
    return answer