phone_book=["123","1234","4235","567","88"]
def solution(phone_book):
    dictphone={}
    for i in phone_book:
        if dictphone.get(i[0],None):
            for j in dictphone[i[0]]:
                if i.startswith(j):
                    return False 
            dictphone[i[0]].append(i)
        else:
            dictphone[i[0]] =[i]
    else: return True
        

    
print(solution(phone_book))
