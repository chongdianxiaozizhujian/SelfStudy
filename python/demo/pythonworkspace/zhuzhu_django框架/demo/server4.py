from wsgiref.simple_server import make_server

import time

def f1(request):
    return [b'<h1>Hello book</h1>']
def f2(request):
    return [b'<h1>Hello web</h1>']
def currentTime(request):
    f=open("currentTime.html",'rb')
    data=f.read()
    curTime = time.ctime(time.time())
    data = str(data,'utf8').replace("!curTime!",str(curTime))
    return [data.encode('utf8')]

def routers():
    urlpatterns = (
        ('/book',f1),
        ('/web',f2),
        ('/currentTime',currentTime),
    )
    return urlpatterns

# 通过environ封装成一个所有请求信息的字典对象
# start_response可以很方便地设置响应头
def application(environ, start_response):
    # 响应头
    start_response('200 OK', [('Content-Type', 'text/html')])
    path = environ["PATH_INFO"]

    urlpatterns = routers()
    func = None
    for item in urlpatterns:
        if item[0] == path:
            func = item[1]
            break
    if func:
        return func(environ)
    else:
        return [b'<h1>404</h1>']
    # if path == '/book':
    #     return f1(environ)
    # elif path == '/web':
    #     return f2(environ)
    # else:
    #     return [b'404']

    # 响应体
    # return [b'<h1>Hello Python!</h1>']

# 封装socket对象以及准备过程(socket、bind、listen)
httpd = make_server('', 8080, application)

print('Serving HTTP on port 8080...')

# 开始监听HTTP请求
httpd.serve_forever()