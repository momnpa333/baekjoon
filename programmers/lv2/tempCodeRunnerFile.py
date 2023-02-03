    if check[tmp[0]+dir[i][0]][tmp[1]+dir[i][1]]==0 and place[tmp[0]+dir[i]][[tmp[1]+dir[i]]]=="O":
                            check[tmp[0]+dir[i][0]][tmp[1]+dir[i][1]]=1
                            queue.append([tmp[0]+dir[i][0],tmp[1]+dir[i][1]])
                        if check[tmp[0]+dir[i][0]][tmp[1]+dir[i][1]]==0 and place[tmp[0]+dir[i]][[tmp[1]+dir[i]]]=="P":
                            return 0