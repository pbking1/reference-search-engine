from flask import Flask

app = Flask(__name__)
app.config.update(
		SECRET_KEY='111111'
		)

#app.config.from_object('config')
from app import views
