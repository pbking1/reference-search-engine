import _mysql
import MySQLdb
import os
import subprocess

#connect to mysql
#conn = MySQLdb.connect('localhost', 'root', '13823201933', 'reference_db')
#x = conn.cursor()
f = open("data.csv", "w")
#insert data
str1 = "cat ./data/"
str2 = " | grep '"
str3 = "'"
for i in range(1,334):
	field1 = "Reference Type:"
	field1_content = str1 + str(i) + str2 + field1 + str3
	field2 = "Record Number:"
	field2_content = str1 + str(i) + str2 + field2 + str3
	field3 = "Author:"
	field3_content = str1 + str(i) + str2 + field3 + str3
	field4 = "Year:"
	field4_content = str1 + str(i) + str2 + field4 + str3
	field5 = "^Title:"
	field5_content = str1 + str(i) + str2 + field5 + str3
	field6 = "^Journal:"
	field6_content = str1 + str(i) + str2 + field6 + str3
	field7 = "Volume:"
	field7_content = str1 + str(i) + str2 + field7 + str3
	field8 = "Issue:"
	field8_content = str1 + str(i) + str2 + field8 + str3
	field9 = "Pages:"
	field9_content = str1 + str(i) + str2 + field9 + str3
	field10 = "Short Title:"
	field10_content = str1 + str(i) + str2 + field10 + str3
	field11 = "Alternate Journal:"
	field11_content = str1 + str(i) + str2 + field11 + str3
	field12 = "ISSN:"
	field12_content = str1 + str(i) + str2 + field12 + str3
	field13 = "PMCID:"
	field13_content = str1 + str(i) + str2 + field13 + str3
	field14 = "Accession Number:"
	field14_content = str1 + str(i) + str2 + field14 + str3
	field15 = "Abstract:"
	field15_content = str1 + str(i) + str2 + field15 + str3
	field16 = "Notes:"
	field16_content = str1 + str(i) + str2 + field16 + str3
	field17 = "URL:"
	field17_content = str1 + str(i) + str2 + field17 + str3
	field18 = "Author Address:"
	field18_content = str1 + str(i) + str2 + field18 + str3

	#doc = {field1:os.popen(field1_content).read(), field2:os.popen(field2_content).read(),
	#field3:os.popen(field3_content).read(), field4:os.popen(field4_content).read(), field5:os.popen(field5_content).read(),
	#field6:os.popen(field6_content).read(), field7:os.popen(field7_content).read(), field8:os.popen(field8_content).read(),
	#field9:os.popen(field9_content).read(), field10:os.popen(field10_content).read(), field11:os.popen(field11_content).read(),
	#field12:os.popen(field12_content).read(), field13:os.popen(field13_content).read(), field14:os.popen(field14_content).read(),
	#field15:os.popen(field15_content).read(), field16:os.popen(field16_content).read(), field17:os.popen(field17_content).read(),
	#field18:os.popen(field18_content).read()}
	
	#os.popen(field1_content).read(),os.popen(field2_content).read(),os.popen(field3_content).read(), field4:os.popen(field4_content).read(), field5:os.popen(field5_content).read(),field6:os.popen(field6_content).read(), field7:os.popen(field7_content).read(), field8:os.popen(field8_content).read(),field9:os.popen(field9_content).read(), os.popen(field10_content).read(), os.popen(field11_content).read(),os.popen(field12_content).read(), os.popen(field13_content).read(), os.popen(field14_content).read(),os.popen(field15_content).read(), os.popen(field16_content).read(), os.popen(field17_content).read(),os.popen(field18_content).read()}

	#str4 = "id,ReferenceType,Record_Number,Author,Year,Journal,Volume,Issue,Pages,Short_Title,Alternate_Journal,ISSN,PMCID,Accession_Number,Abstract,Notes,URL,Author_Address"
	#field1_content_str = str(os.popen(field1_content).read())
	#x.execute("insert into reference1(ReferenceType) values(%s);", (field1_content_str,))
	#x.execute("select * from reference1;")
	#x.execute("""insert into reference(ReferenceType,Record_Number,Author,Year,Journal,Volume,Issue,Pages,Short_Title,Alternate_Journal,ISSN,PMCID,Accession_Number,Abstract,Notes,URL,Author_Address) values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);""", (str(os.popen(field1_content).read()),str(os.popen(field2_content).read()),str(os.popen(field3_content).read()), str(field4:os.popen(field4_content).read()), str(field5:os.popen(field5_content).read()),str(field6:os.popen(field6_content).read()), str(field7:os.popen(field7_content).read()), str(field8:os.popen(field8_content).read()),str(field9:os.popen(field9_content).read()), str(os.popen(field10_content).read()), str(os.popen(field11_content).read()),str(os.popen(field12_content).read()), str(os.popen(field13_content).read()), str(os.popen(field14_content).read()),str(os.popen(field15_content).read()), str(os.popen(field16_content).read()), str(os.popen(field17_content).read()), str(os.popen(field18_content).read())))
	#x.execute("desc reference;")
#	conn.commit()
	#print os.popen(field1_content).read()
	field1_content1 = str(os.popen(field1_content).read())
	field1_content2 = str(os.popen(field2_content).read())
	field1_content3 = str(os.popen(field3_content).read())
	field1_content4 = str(os.popen(field4_content).read())
	field1_content5 = str(os.popen(field5_content).read())
	field1_content6 = str(os.popen(field6_content).read())
	field1_content7 = str(os.popen(field7_content).read())
	field1_content8 = str(os.popen(field8_content).read())
	field1_content9 = str(os.popen(field9_content).read())
	field1_content10 = str(os.popen(field10_content).read())
	field1_content11 = str(os.popen(field11_content).read())
	field1_content12 = str(os.popen(field12_content).read())
	field1_content13 = str(os.popen(field13_content).read())
	field1_content14 = str(os.popen(field14_content).read())
	field1_content15 = str(os.popen(field15_content).read())
	field1_content16 = str(os.popen(field16_content).read())
	field1_content17 = str(os.popen(field17_content).read())
	field1_content18 = str(os.popen(field18_content).read())

	#str5 = str(os.popen(field1_content).read())+str(os.popen(field2_content).read())+str(os.popen(field3_content).read())+ str(field4:os.popen(field4_content).read())+ str(field5:os.popen(field5_content).read())+str(field6:os.popen(field6_content).read())+ str(field7:os.popen(field7_content).read())+ str(field8:os.popen(field8_content).read())+str(field9:os.popen(field9_content).read())+ str(os.popen(field10_content).read())+ str(os.popen(field11_content).read())+str(os.popen(field12_content).read())+ str(os.popen(field13_content).read())+ str(os.popen(field14_content).read())+str(os.popen(field15_content).read())+ str(os.popen(field16_content).read())+ str(os.popen(field17_content).read())+ str(os.popen(field18_content).read())
	f.write(field1_content1 + " :: " + field1_content2 + " :: " + field1_content3 + " :: " + field1_content4 + " :: " + field1_content5  + " :: " + field1_content6  + " :: " + field1_content7  + " :: " + field1_content8  + " :: " + field1_content9  + " :: " + field1_content10  + " :: " + field1_content11  + " :: " + field1_content12  + " :: " + field1_content13  + " :: " + field1_content14  + " :: " + field1_content15  + " :: " + field1_content16  + " :: " + field1_content17 + " :: " + field1_content18 + " :: ")
	f.write("_:::_\n")
#print x.fetchall()
#conn.close()