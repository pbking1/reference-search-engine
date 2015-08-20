from flask import Flask, session, redirect, url_for, escape, request
import MySQLdb
import _mysql
from numpy import genfromtxt

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def index():
    if 'key' in session:
        db = _mysql.connect("localhost", "pb", "xxxxxxx")
        db.query("""use image_brain_new""")
        db.query("""select * from image_db where Precentral_Left like """ + session['key'] + """;""")
        res = db.store_result().fetch_row()[0]
        
        return 'The result is %s' % escape(str(res))
    return 'No Result'

@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        session['key'] = request.form['username']
        return redirect(url_for('index'))
    return '''
        <form action="" method="post">
        <p><input type=text name=username>
        <p><input type=submit value=Search>
        </form>
        '''


# set the secret key.  keep this really secret:
app.secret_key = 'aaaa'

if __name__ == '__main__':
    app.debug = True
    app.run()
