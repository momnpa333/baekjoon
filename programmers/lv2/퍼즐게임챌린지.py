import sys
answer=10**15
def solution(diffs, times, limit):
    binary(diffs, times, limit,1,answer)
    return answer

def solve(diffs, times, limit,level):
    time=0
    prev_time=0
    for diff,cur_time in zip(diffs,times):
        if diff<=level:
            time+=cur_time
        else:
            time+=(cur_time+prev_time)*(diff-level)+cur_time
        prev_time=cur_time
    return time

def binary(diffs, times, limit,left,right):
    global answer
    if left>right:
        return
    mid=(left+right)//2
    if solve(diffs, times, limit,mid)<=limit:
        answer=min(answer,mid)
        binary(diffs, times, limit,left,mid-1)
    else:
        binary(diffs, times, limit,mid+1,right)
        