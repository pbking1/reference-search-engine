from django.conf.urls import include, url
from django.contrib import admin
import settings

urlpatterns = [
    # Examples:
    url(r'^index/$', 'firsttest.views.index'),
    url(r'^hello/$', 'firsttest.views.hello_world'),
    # url(r'^blog/', include('blog.urls')),

    #picture and other asset
    url(r'asset/(?P<path>.*)$', 'django.views.static.serve', {'document_root':settings.MEDIA_ROOT}),

    url(r'^admin/', include(admin.site.urls)),
]
