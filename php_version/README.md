###Reference query website
####set up the website
- select full field and export the enl file to a txt file named (field_name.txt)
	- and use `python read_data.py` to split the txt into id based file
- then, run `python load_data_into_csv.py` and store the data in data.csv
- change the absolute path of data.csv file in the insert_sql.sql to your computer path
- after that, run `mysql -uroot -p` 
	- create a database named reference_db
	- and then log out 
		- use `mysql -uroot -p < insert_sql.sql`
		- the data will be load into the mysql database of your computer

####how to run the website
- remember to connect to the Internet when using the website, because the js file is directly reference from the offical website.
- And we need apache and php environment set up in the server too
	- and then put the db_connect.php and index.php in the folder of server
	- visit localhost/version1
