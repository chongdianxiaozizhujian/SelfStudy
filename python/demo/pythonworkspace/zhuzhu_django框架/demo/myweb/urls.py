from server2 import currentTime,f1,f2
def routers():
    urlpatterns = (
        ('/book',f1),
        ('/web',f2),
        ('/currentTime',currentTime),
    )
    return urlpatterns