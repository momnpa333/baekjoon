from collections import deque
import sys   
sys.setrecursionlimit(10000)


maps=[[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1]]
#maps=[[1,1,1],[1,1,1]]
def solution(maps):
    #사방 벽으로 만들기
    newmaps = [[0 for _ in range(len(maps[0])+2)] for _ in range(len(maps)+2)]
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            newmaps[i+1][j+1]=maps[i][j]
    #체크할 배열
    check = [[0 for _ in range(len(maps[0])+2)] for _ in range(len(maps)+2)]
    
    count=1
    def bfs(newqueue):
        next=[]
        nonlocal count
        count+=1
        newqueue=deque(newqueue)
        #큐에서 꺼내기
        while True:
            if len(newqueue)==0:
                break
            tmp=newqueue.popleft()
            r=tmp[0]
            c=tmp[1]
            #map이 안막혀있고 간적이 없으면 next배열에 넣고 check
            if newmaps[r][c+1]!=0 and check[r][c+1]==0:
                #탈출성공
                if r==len(maps) and c+1==len(maps[0]):            
                    check[r][c+1]=count
                    return count
                check[r][c+1]=count
                next.append([r,c+1])
            if newmaps[r+1][c]!=0 and check[r+1][c]==0:
                #탈출성공
                if r+1==len(maps) and c==len(maps[0]):            
                    check[r+1][c]=count
                    return count
                check[r+1][c]=count
                next.append([r+1,c])
            if newmaps[r][c-1]!=0 and check[r][c-1]==0:
                #탈출성공
                if r==len(maps) and c-1==len(maps[0]):            
                    check[r][c-1]=count
                    return count
                check[r][c-1]=count
                next.append([r,c-1])
            if newmaps[r-1][c]!=0 and check[r-1][c]==0:
                #탈출성공
                if r-1==len(maps) and c==len(maps[0]):            
                    check[r-1][c]=count
                    return count
                check[r-1][c]=count
                next.append([r-1,c])
        #다막혀있고 간적이 있으면 탈출실패
        if len(next)==0:
            return -1
        return(bfs(next))
    check[1][1]=count
    return bfs([[1,1]])
print(solution(maps))
        






