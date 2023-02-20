from collections import Counter
def solution(n, computers):
    answer = 0
    parent=[]
    for i in range(n):
        parent.append(i)
        
    def tmp():
        for i in range(n):
            for j in range(i,n):
                if i!=j and computers[i][j]==1:
                    parent[i]=min(parent[i],parent[j])
                    parent[j]=min(parent[i],parent[j])
    tmp();tmp();tmp()
    answer=(len(Counter(parent)))
             
        
    return answer