opcode={
    "ADD":0,
    "ADDC":1,
    "SUB":2,
    "SUBC":3,
    "MOV":4,
    "MOVC":5,
    "AND":6,
    "ANDC":7,
    "OR":8,
    "ORC":9,
    "NOT":10,
    "MULT":12,
    "MULTC":13,
    "LSFTL":14,
    "LSFTLC":15,
    "LSFTR":16,
    "LSFTRC":17,
    "ASFTR":18,
    "ASFTRC":19,
    "RL":20,
    "RLC":21,
    "RR":22,
    "RRC":23
}

N=int(input())
ary=[]
for i in range(N):
    ary.append(input().split(" "))
answer=[]

for i in ary:
    cmd=""
    cmd+=(format(opcode[i[0]],'b').rjust(5,"0"))
    cmd+="0"
    cmd+=(format(int(i[1]),'b').rjust(3,"0"))
    cmd+=(format(int(i[2]),'b').rjust(3,"0"))
    #print(i[3])
    if cmd[4]=="0":
        cmd+=(format(int(i[3]),'b').rjust(3,"0"))
        cmd+="0"
    else:
        cmd+=(format(int(i[3]),'b').rjust(4,"0"))
    print(cmd)
    
