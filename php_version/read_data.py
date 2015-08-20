import os
import subprocess


for i in range(1,334):
	f = open("field_name.txt")
	line = f.readlines()
	count = 0
	for j in line:
		str1 = "cat data/"
		str2 = " | grep '"
		cmd = str1 + str(i) + str2 + str(j).strip("\n") + "'"
		output = os.popen(cmd)
		print output.read()
