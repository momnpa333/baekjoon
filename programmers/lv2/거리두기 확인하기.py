places=[["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]
def solution(places):
    answer = []
    dir=[[0,1],[1,0],[0,-1],[-1,0]]
    check=[[0 for _ in range(5)]for _ in range(5)]
    queue=[]
    place=[]
    flag=0
    def bfs(row,col):
        nonlocal check
        queue.append([row,col])
        depth=0
        check[row][col]=1
        while True:
            T=len(queue)
            depth+=1
            while T>0:
                tmp=queue.pop(0)
                for i in range(4):
                    if (tmp[0]+dir[i][0]<=4) and (tmp[1]+dir[i][1]<=4) and (tmp[0]+dir[i][0]>=0) and (tmp[1]+dir[i][1]>=0):
                        if check[tmp[0]+dir[i][0]][tmp[1]+dir[i][1]]==0 and place[tmp[0]+dir[i][0]][tmp[1]+dir[i][1]]=="O":
                            check[tmp[0]+dir[i][0]][tmp[1]+dir[i][1]]=1
                            queue.append([tmp[0]+dir[i][0],tmp[1]+dir[i][1]])
                        if check[tmp[0]+dir[i][0]][tmp[1]+dir[i][1]]==0 and place[tmp[0]+dir[i][0]][tmp[1]+dir[i][1]]=="P":
                            return 0
                T-=1
            if depth>=2:
                break
        check=[[0 for _ in range(5)]for _ in range(5)]
        return 1
            
    for place in places:
        for i in range(4):
            for j in range(4):
                if(bfs(i,j)==0):
                    answer.append(0)
                    flag=1
                    break
            if(flag==1):
                break
        else:
            answer.append(1)
        flag=0
    return answer
print(solution(places))