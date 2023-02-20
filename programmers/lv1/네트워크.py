from collections import Counter
def solution(n, computers):
    answer = 0
    parent=[]
    for i in range(n):
        parent.append(i)
    def findparent(n):
        if parent[n]==n:
            return n 
        parent[n]=findparnet(parent[n])
        return parent[n]
    for i in range(n):
        for j in range(i,n):
            if i!=j and computers[i][j]==1:
                parent[i]=min(parent[i],parent[j])
                parent[j]=min(parent[i],parent[j])
    for i in range(n):
        for j in range(i,n):
            if i!=j and computers[i][j]==1:
                parent[i]=min(parent[i],parent[j])
                parent[j]=min(parent[i],parent[j])
                
    for i in range(n):
        for j in range(i,n):
            if i!=j and computers[i][j]==1:
                parent[i]=min(parent[i],parent[j])
                parent[j]=min(parent[i],parent[j])
    answer=(len(Counter(parent)))
        
        
    return answer