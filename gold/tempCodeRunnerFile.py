from collections import deque

N,K=map(int,input().split(' '))

count_board=[float('inf')]*100001

def fastmove(pos,cnt,K):
    if pos==K:
        print(cnt)
        exit(0)
    if pos==0 and count_board[pos]==float('inf'):
        count_board[pos]=cnt
    # count_board[pos]=cnt
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
            pos*=2

def findstart(cnt):
    ret=[]
    for idx,pos in enumerate(count_board):
        if pos==cnt:
            ret.append(idx)
    return ret

dq=deque()
fastmove(N,0,K)
for item in findstart(0):
    dq.append((item,0))
while dq:
    # print(dq)
    for _ in range(len(dq)):
        start_point,cnt=dq.popleft()
        for add_point in (-1,1):
            if 0<=start_point+add_point<100001 and count_board[start_point+add_point]==float('inf'):
                # count_board[start_point+add_point]=cnt+1
                fastmove(start_point+add_point,cnt+1,K)
    for item in findstart(cnt+1):
        dq.append((item,cnt+1))




