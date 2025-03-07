from collections import deque
S=list(map(str,input()))
stack=[]; keyDict={'[':(']',3),'(':(')',2)}
score=deque([])
while S:
    item=S.pop()
    if item in keyDict:
        if len(stack)==0 or stack[-1]!=keyDict[item][0]:
            print(0)
            exit(0)
        else:
            stack.pop()
            score.append(((keyDict[item][1]),len(stack)))
    else:
        stack.append(item)
if len(stack)>0:
    print(0)
    exit(0)
answer=[0]*30
prev_point,pre_lv=score.popleft()
answer[pre_lv]+=prev_point
# print(score)
while score:
    point,lv=score.popleft()
    # print(answer,point,lv)
    if lv<pre_lv:
        answer[lv]+=point*answer[pre_lv]; 
        answer[pre_lv]=0; 
        pre_lv=lv
    elif lv==pre_lv:
        answer[lv]+=point
    else:
        answer[lv]=point
        pre_lv=lv; prev_point=point
print(answer[0])




