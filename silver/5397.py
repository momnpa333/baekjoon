import sys
input=sys.stdin.readline
T=int(input())

def make_node(value):
    global cnt
    return [None,value,None]

def insert_node(cur,value):
    global head
    Node=make_node(value)

    if cur==None:
        cur=Node
        if head==None:
            head=Node
    else:
        Node[2]=cur[2]
        Node[0]=cur
        if cur[2]!=None:
            cur[2][0]=Node
        cur[2]=Node
        cur=Node
    return cur

def delete_node(cur):
    #헤드
    global head
    if cur==head:
        return cur
    elif cur[2]==None:
        cur[0][2]=None
        cur=cur[0]
        return cur
    else:
        cur[0][2]=cur[2]
        cur[2][0]=cur[0]
        cur=cur[0]
        return cur



def print_node(head):
    ret=""
    while True:
        ret+=head[1]
        if head[2]==None:
            break
        head=head[2]
    return ret[1:]


for _ in range(T):
    S=input().rstrip()
    head=[None,"!",None]; cur=head
    for s in S:
        if s.isalpha() or s.isdigit():
            cur=insert_node(cur,s)
        elif s=="<":
            if cur!=head:
                cur=cur[0]
        elif s==">":
            if cur!=None and cur[2]!=None:
                cur=cur[2]
        elif s=="-":
            cur=delete_node(cur)

            
    ret=print_node(head)
    print(ret)

