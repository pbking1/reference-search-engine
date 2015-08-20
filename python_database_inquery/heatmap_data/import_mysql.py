#the package MySQLdb and _mysql should be installed
#there is instruction in the following url
#        http://mysql-python.sourceforge.net/MySQLdb.html

import MySQLdb
import _mysql
from numpy import genfromtxt

db = _mysql.connect("localhost", "pb", "xxxxxxx")
db.query("""create database if not exists image_brain_new""")
db.query("""use image_brain_new""")

#db.query("""drop table image_db;""")
f1 = open("label.txt")
s1 = "create table if not exists image_db("
s1_suffix = " ); "
query_s = s1
temp_str = ""
for i in f1.readlines():
	query_s = query_s + str(i).strip("\n") + " float,"
	temp_str = temp_str + str(i).strip("\n") + ","
query_s = query_s.strip(",")
query_s = query_s + s1_suffix
db.query(query_s)

data = genfromtxt('ADNI_GWAS_logp_1e-5.txt', delimiter = ",")
data_transpose = data.transpose()

for i in data_transpose:
	col1 = ""
	for k in range(0, 116):
        #print str(i[k]).strip("\n") + " "
		col1 = col1 + str(i[k]).strip("\n") + ","	
	query_str = "INSERT into image_db(" + temp_str.strip(",") + ") VALUES ("
	result_query = query_str + col1.strip(",") + ")"
	#print result_query	
	db.query(result_query)

db.query("""select * from image_db;""")
print db.store_result().fetch_row()[0][0]







