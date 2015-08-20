from flask import Flask, session, redirect, url_for, escape, request
import MySQLdb
import _mysql
from numpy import genfromtxt

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def index():
    if 'key' in session:
        db = _mysql.connect("localhost", "pb", "xxxxxxxx")
        db.query("""use reference_db""")
        db.query("""select * from reference where id like '%""" + session['id'] + """%' and ReferenceType like '%""" + session['ReferenceType'] + """%' and Record_Number like '%""" + session['Record_Number'] + """%';""")
        res = db.store_result().fetch_row()
        
        return 'The result is %s' % escape(str(res))
    return 'No Result'

@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        session['id'] = request.form['id']
        session['ReferenceType'] = request.form['ReferenceType']
        session['Record_Number'] = request.form['Record_Number']
        
        return redirect(url_for('index'))
    return '''
        <form action="" method="post">
        <p>ID: <input type=text name=id>
        <p>ReferenceType:<input type=text name=ReferenceType>
        <p>Record Number:<input type=text name=Record_Number>
        <p><input type=submit value=Search>
        </form>
        '''


# set the secret key.  keep this really secret:
app.secret_key = 'aaaa'

if __name__ == '__main__':
    app.debug = True
    app.run()
