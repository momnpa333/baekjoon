id_pw=[]
id_pw=["meosseugi", "1234"]
db=[]
db=[["rardss", "123"], ["yyoom", "1234"], ["meosseugi", "1234"]]
def solution(id_pw, db):
    for i in db:
        if id_pw[0]==i[0]:
            if id_pw[1]==i[1]:
                return 'login'
            return 'wrong pw'
    else:
        return 'fail'
print(solution(id_pw, db))
