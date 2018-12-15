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