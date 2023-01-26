import random
f=open("navi.dll","w")

for i in range(1,21):
    string="INSERT INTO BOOK_INFO VALUES ( '%d', '%s','%s' );\n"%(i,'A'+str(i),'KWON')
    f.write(string)
f.close()


#string="INSERT INTO BOOK VALUES ( '%d', '%d', '%s','%d','%d' )\n"%(i,random.randint(1,3),'TRUE',random.randint(1,20),random.randint(1,3))

   