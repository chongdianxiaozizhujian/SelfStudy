# fo = open("demo.txt", "wb")
# print(fo.name)
# print(fo.fileno())
# print(fo.isatty())
# fo.flush()
# fo.close()
# import sys
# print(sys.getdefaultencoding())
# fo = open("demo.txt", "rb")
# print(fo.name)
# for index in range(5):
#     line = next(fo)
#     print("第%d行 - %s"%(index, line.decode('utf-8')))
# fo.flush()
# fo.close()
# print(sys.getdefaultencoding())
# fo = open("demo.txt", "rb")
# print(fo.name)
# # 3 6 9 一个汉字占用3个字节
# line = fo.read(3)
# print(line.decode('utf-8'))
# fo.close()
# fo = open("demo2.txt", 'r')
# print(fo.name)
# for line in fo.readlines():
#     line = line.strip()
#     print(line)
# fo.close()
# fo = open("demo2.txt", 'r+')
# line = fo.readline()
# print(line)
# line = fo.readline(5)
# print(line)
# fo.close()
# fo = open("demo2.txt", 'r+')
# line = fo.readline()
# print(line)
# fo.seek(0,2)
# line = fo.readline()
# print(line)
# fo.close()
# fo = open("demo2.txt", 'r+')
# line = fo.readline()
# print(line)
# pos = fo.tell()
# print(pos)
# fo.close()
# fo = open("demo2.txt", 'r+')
# line = fo.readlines()
# print(line)
# line = fo.readline()
# print(line)
# line = fo.truncate(10)
# 无 size 表示从当前位置截断
# 第一次fo.readline()读了一行后，当前位置在第二行,所以后面的fo.readlines()只会返回四行数据
# 并且截取后,文件的内容会有变化
# line = fo.readlines()
# print(line)
# fo = open("demo2.txt", 'r+')
# str = "www.youyou.com"
# fo.write(str)
# for line in fo.readlines():
#     line = line.strip()
#     print (line)
# # fo.close()
# fo = open("demo3.txt", 'w')
# strs = ["www.youyou.com","www.youyou.com"]
# fo.writelines(strs)
# fo.close()
# fo1 = open("demo3.txt", 'r')
# for line in fo1.readlines():
#     line = line.strip()
#     print (line)
# fo.close()
# def getfile_fix(filename):
#     return filename[filename.rfind('.')+1:]
# print(getfile_fix('test.txt'))

'''
不能能直接write()后，就进行读取，这样读不到数据，
因为数据对象到达的地方为文件最后，读取是向后读的，
因此，会读到空白，应该先把文件对象移到文件首位
'''
# f = open("forwrite.txt", 'w+', encoding='utf-8')
# f.write('do or not do , this is a question')
# s=f.tell()
# f.seek(0,0)
# str=f.read()
# print(s,str,len(str))
# f.close()





