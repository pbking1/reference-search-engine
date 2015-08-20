from django.shortcuts import render
from django.http import HttpResponse
from datetime import datetime
import sys
import xapian
from firsttest.models import search_result
from django.http import HttpResponseRedirect
from django.shortcuts import render_to_response
from django.views.decorators.csrf import csrf_exempt


# first page
def index(request):
    #request.session['key_word'] = '1'
    if request.method == "POST":
        #request.session['key_word'] = request.POST.get('key_value', None)
        #print request.POST['key_word']
        request.session['key_word'] = request.POST['key_word']
        return HttpResponseRedirect('../hello')
    #return render_to_response('index.html', {'key_value':key})   
    return render(request, 'index.html')

# Create your views here.
def hello_world(request):
    # Open the database for searching.
    database = xapian.Database("/home/pb/Documents/python/django_test/mysite/firsttest/index")

    # Start an enquire session.
    enquire = xapian.Enquire(database)

    # Combine the rest of the command line arguments with spaces between
    # them, so that simple queries don't have to be quoted at the shell
    # level.

    #second parameter is the search key word
    #str_key = request.session['key_word']
    str_key = request.session.get('key_word')
    query_string=str.join(' ', str(str_key))

    # Parse the query string to produce a Xapian::Query object.
    qp = xapian.QueryParser()
    stemmer = xapian.Stem("english")
    qp.set_stemmer(stemmer)
    qp.set_database(database)
    qp.set_stemming_strategy(xapian.QueryParser.STEM_SOME)
    query = qp.parse_query(query_string)
    print "Parsed query is: %s" % str(query)

    # Find the top 10 results for the query.
    enquire.set_query(query)
    matches = enquire.get_mset(0, 10)
    
    # Display the results.
    print "%i results found." % matches.get_matches_estimated()
    result_found = matches.get_matches_estimated()
    print "Results 1-%i:" % matches.size()
    
    #remove all the data in the database first, and then displace them
    search_result1 = search_result.objects.all() 
    search_result1.delete()
    i = 0
    for m in matches:
        i = i + 1
        #generate the filename
        temp_str = str(m.document.get_data()).split(" sample=")
        temp = temp_str[0]
        file_name = temp.strip("url=/")
        print "result file name ::: " + file_name[0:4].strip("\ns")
        file_name1 = file_name[0:4].strip("\ns")
        #create object
	search_result.objects.create(result_id= i, total_result_number=str(result_found),match_rate=str(m.percent),doc_id=str(file_name1),content=str(m.document.get_data()))
    #the file name is store in url

    return render(request, 'hello_world.html', {'result': (search_result.objects.all())})
