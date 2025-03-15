def solution(expressions):
    quiz=[]
    check=[True]*10
    check[0]=False;check[1]=False
    for express in expressions:
        if express[-1]=="X":
            quiz.append(express)
        cut=express.split(" ")
        find_base(check,cut)
    base=[]
    for idx,candi in enumerate(check):
        if check[idx]==True:
            base.append(idx)
            
    answer = []
    for exp in quiz:
        answer.append(solve(exp,base))
    return answer
def find_base(check,cut):
    for i in range(2,10):
        try:
            A=int(cut[0],i)
            B=int(cut[2],i)
            if cut[-1]=='X':
                continue
            C=int(cut[4],i)
            if cut[1]=='+':
                if A+B!=C:
                    check[i]=False
            if cut[1]=='-':
                if A-B!=C:
                    check[i]=False
        except:
            check[i]=False
def solve(exp,base):
    cut=exp.split()
    ret=0
    candi=set()
    for i in base:
        A=int(cut[0],i)
        B=int(cut[2],i)
        
        if cut[1]=='+':
            C=int(trans(A+B,i))
            candi.add(C)
            ret=C
        if cut[1]=='-':
            C=int(trans(A-B,i))
            candi.add(C)
            ret=C
    if len(candi)!=1:
        return exp.rstrip('X')+'?'
    return exp.replace('X','')+str(ret)
    
def trans(num,i):
    ret=""
    while True:
        if i>num:
            ret+=str(num)
            break
        ret+=str(num%i)
        num//=i
    return ret[::-1]
        

    
    
    
    
    