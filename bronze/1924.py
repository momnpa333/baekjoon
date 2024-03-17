#2007 1월 1일 월
# x월 y일은 무슨 요일?
# 1. 달력 배열 만들기


x,y=map(int,input().split())
M1=(["MON", "TUE","WED", "THU", "FRI", "SAT","SUN"]*5)[:31:]
M2=(["MON", "TUE","WED", "THU", "FRI", "SAT","SUN"]*5)[3:28+3:]
M3=(["MON", "TUE","WED", "THU", "FRI", "SAT","SUN"]*5)[3:31+3:]
M4=(["MON", "TUE","WED", "THU", "FRI", "SAT","SUN"]*6)[6:30+6:]
M5=(["MON", "TUE","WED", "THU", "FRI", "SAT","SUN"]*6)[1:31+1:]
M6=(["MON", "TUE","WED", "THU", "FRI", "SAT","SUN"]*5)[4:30+4:]
M7=(["MON", "TUE","WED", "THU", "FRI", "SAT","SUN"]*6)[6:31+6:]
M8=(["MON", "TUE","WED", "THU", "FRI", "SAT","SUN"]*5)[2:31+2:]
M9=(["MON", "TUE","WED", "THU", "FRI", "SAT","SUN"]*5)[5:30+5:]
M10=(["MON", "TUE","WED", "THU", "FRI", "SAT","SUN"]*5)[:31:]
M11=(["MON", "TUE","WED", "THU", "FRI", "SAT","SUN"]*5)[3:30+3:]
M12=(["MON", "TUE","WED", "THU", "FRI", "SAT","SUN"]*6)[5:31+5:]
calender=[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12]
print(calender[x-1][y-1])
