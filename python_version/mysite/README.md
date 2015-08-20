###reference search engine

####technique
- use xapian and python django
- the xapian-core library and xapian-binding version should be the same
	- or the installation will fail
	- and it would be good to install in linux rather then window

####how to run
- use 'python manage.py migrate' to update the model
	- for example if you want to add more field in the model
		- after you add the model, you should use the command to update
- use the command 'python manage.py runserver' to run the server 
	- you can type this command with a '&' and enable the server in background
- go to 127.0.0.1:8000/hello to see the page
	- this will only work when you have server running in the background
