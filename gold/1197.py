import sys
input=sys.stdin.readline

V,E=map(int,input().split())

edges=[list(map(int,input().split())) for i in range(E)]

parents=[i for i in range(V+1)]

answer=0
def find(parent):
    if parents[parent]==parent:
        return parent
    else:
        return(find(parents[parent]))

def update(parent,edit):
    if parents[parent]==parent:
        parents[parent] = edit
        return parent
    else:
        tmp=parents[parent]
        parents[parent] = edit
        return(update(tmp,edit))


def is_connected(a,b):
    a_find=find(a)
    b_find=find(b)
    if a_find==b_find:
        return True
    else:
        if a_find<b_find:
            update(b,a_find)
        else:
            update(a,b_find)
        return False
edges=sorted(edges, key=lambda x:x[2])
for edge in edges:
    if (is_connected(edge[0],edge[1])==False):
        answer+=edge[2]

print(answer)