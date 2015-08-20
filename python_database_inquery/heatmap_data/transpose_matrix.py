from numpy import genfromtxt
data = genfromtxt('ADNI_GWAS_logp_1e-5.txt', delimiter = ",")
data_transpose = data.transpose()
for i in data_transpose:
	for k in range(0, 116):
		print str(i[k]) + " "
	print "\n"
