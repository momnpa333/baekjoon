import sys
input=sys.stdin.readline
from collections import Counter

species=[]
while True:
    specie=input().strip()
    if not specie:
        break
    else:species.append(specie)

for (key,value) in sorted(dict(Counter(species)).items()):
    value = value/len(species)*100
    print("%s %.4f" % (key,value))

    
