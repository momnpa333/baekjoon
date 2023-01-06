before="olleh"
after="heloo"	

def solution(before, after):
    before=sorted(before)
    dict1={string:before.count(string) for string in before}
    print(dict1)
    after=sorted(after)
    dict2={string:after.count(string) for string in after}
    if dict1 == dict2:
        return 1
    else:
        return 0
print(solution(before, after))