from flask.ext.wtf import Form
from wtforms import StringField, BooleanField
from wtforms.validators import DataRequired

class search_key(Form):
	openid = StringField('openid', validators=[DataRequired()])

