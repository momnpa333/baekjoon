from collections import deque

N,K=map(int,input().split(' '))

count_board=[float('inf')]*100001

def fastmove(pos,cnt,K):
    ret=[]
    if pos==K:
        print(cnt)
        exit(0)
    if count_board[pos]==float('inf'):
        count_board[pos]=cnt
        ret.append(pos)
        pos*=2
    else:
        return ret
    if pos!=0:
        while pos<100001:
            if pos==K:
                print(cnt)
                exit(0)
            # if count_board[pos]==float('inf'):
            #     count_board[pos]=cnt
            if count_board[pos]!=float('inf'):
                break
            if pos+1>K*2:
                break
            count_board[pos]=cnt
            ret.append(pos)
            pos*=2
    return ret

def findstart(cnt):
    ret=[]
    for idx,pos in enumerate(count_board):
        if pos==cnt:
            ret.append(idx)
    return ret

dq=deque()
next=fastmove(N,0,K)
for item in next:
    dq.append((item,0))
while dq:
    # print(dq)
    next=[]
    for _ in range(len(dq)):
        start_point,cnt=dq.popleft()
        for add_point in (-1,1):
            if 0<=start_point+add_point<100001 and count_board[start_point+add_point]==float('inf'):
                # count_board[start_point+add_point]=cnt+1
                next+=fastmove(start_point+add_point,cnt+1,K)
    next=sorted(next)
    for item in next:
        dq.append((item,cnt+1))




