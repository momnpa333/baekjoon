import sys
from collections import Counter
input = sys.stdin.readline

st=input().upper()
# list=[]
# dict={string:st.count(string)for string in st}
# list=[k for k,v in dict.items() if max(dict.values())==v]
# if(len(list)==1):
#     print(list[0])
# else:
#     print("?")
temp = dict(Counter(st.strip()))
list=[k for k,v in temp.items() if max(temp.values())==v]
if(len(list)==1):
    print(list[0])
else:
    print("?")