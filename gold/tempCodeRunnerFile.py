     if seatLikeAry[i][j]>maxLike:
                    maxLike=seatLikeAry[i][j]
                    maxLikeSeat=[]
                    maxLikeSeat.append((i,j))
                elif seatLikeAry[i][j]==maxLike:
                    maxLikeSeat.append((i,j))