def make_tree(dic,info):
    if len(info)==0:
        return
    if info[0] not in dic:
        dic[info[0]]={}
    make_tree(dic[info[0]],info[1:])

def print_food(dic,depth):
    for k in sorted(dic.keys()):
        print("--"*depth+k)
        print_food(dic[k],depth+1)

n = int(input())
foods = [list(input().split()) for _ in range(n)]
dic = {}
for food in foods:
    make_tree(dic,food[1:])

print_food(dic,0)
