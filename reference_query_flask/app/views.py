#!/usr/bin/env python
# -*- coding: UTF-8 -*-
from whoosh.index import *
from whoosh.fields import *
from whoosh.analysis import RegexAnalyzer
from whoosh.fields import Schema, TEXT, KEYWORD, ID, STORED
from whoosh import qparser
from whoosh import *
from whoosh.qparser import *
from whoosh import scoring
from flask import render_template,flash,redirect
from app import app
from .front_page import search_key
from flask import session
from flask import request

def index_file():
	index_addr = "/Users/pb/Documents/shenli/reference_query_flask/app/static/index"
	analyzer = RegexAnalyzer(ur"(\w+(\.?\w+)*)")
	schema = Schema(title=TEXT(stored=True), path=ID(stored=True), tags=KEYWORD(stored=True), content=TEXT(stored=True, analyzer=analyzer))
	ix = create_in(index_addr, schema)
	writer = ix.writer()

	for j in range(1, 334):
		f = open("/Users/pb/Documents/shenli/reference_query_flask/app/static/data/" + str(j))
		f1 = open("/Users/pb/Documents/shenli/reference_query_flask/app/static/data/" + str(j))
		
		content = ""
		content_tags = ""
		for i in f.readlines():
			content += ("\t" + str(i) + "\t")
		for k in f1.readlines():
			content_tags += ("\n" + str(k) + "\n")

		writer.add_document(title=unicode(str(j), 'utf-8'), path=unicode(str(j), 'utf-8'), tags=unicode(str(content_tags), 'utf-8'), content=unicode(str(content), 'utf-8'))
	writer.commit()

@app.route('/',methods=['GET','POST'])
def search():
	form = search_key()
	if form.validate_on_submit():
		session['key'] = str(form.openid.data)
		flash(form.openid.data)
		return redirect("/search")

	if request.method == 'POST':
		if request.form['index_data'] == 'YES':
			index_file()

	return render_template('index.html', form=form)

@app.route('/search', methods=['GET','POST'])
def index():
	index_addr = "/Users/pb/Documents/shenli/reference_query_flask/app/static/index"
	ind = open_dir(index_addr)
	searcher = ind.searcher(weighting=scoring.TF_IDF())
	#sort the result by score

	parser = qparser.QueryParser("tags", ind.schema)
	parser.add_plugin(qparser.FuzzyTermPlugin())
	user_q = parser.parse(unicode(session['key'], 'utf-8'))
	#user_q = parser.parse(u"is~2")
	#add 2 to set the fuzzy distance to 2

	results = searcher.search(user_q, limit=None)
	res = results
	return render_template('search.html', title='Home',res_count=res.scored_length(), res=res)
