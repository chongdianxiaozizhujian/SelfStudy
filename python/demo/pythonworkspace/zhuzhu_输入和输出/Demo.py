# import math
# s = 'hello,world'
# print(str(s))
# print(repr(s))
# print(str(1/7))
# x = 10 * 3.25
# y = 200 * 200
# print(repr(x))
# print(repr(y))
# # repr()函数可以自动转义字符串中的特殊字符
# hello = 'hello,python\n'
# print(repr(hello))
# a = 3.125
# print(repr(a).ljust(2))
# print('{hello}和{0}和{hello}'.format('hello',hello = 'python'))
# print('{0:.31f}'.format(math.pi))
# ball = {'pingpang': 1, 'basketball': 2, 'football': 3}
# for sport,love in ball.items():
#     print('{0:10}==>{1:10}'.format(sport,love))
# table = {'Google': 1, 'Runoob': 2, 'Taobao': 3}
# print('Runoob: {Runoob:d}; Google: {Google:d}; Taobao: {Taobao:d}'.format(**table))
# print('%2.2f' %math.pi)
# str = input("请输入")
# print()
# print("你输入的内容是" + str)
# f = open("E:\pythonworkspace\zhuzhu_输入和输出\测试.txt", "w")
# f.write("hello python\n")
# f.write("hello python")
# f.close()
# f = open("E:\pythonworkspace\zhuzhu_输入和输出\测试.txt", "r")
# str = f.read()
# print(str)
# f.close()
# str = f.readlines()
# print(str)
# f.close()
# for line in f:
#     print(line, end = '')
# str = f.tell()
# print(str)
# f.close()
# str = f.seek(7)
# print(str)
# s = f.read(1)
# print(s)
# f.close()
'''
文件关闭后不能再次使用该文件,否则会报错
f.close()
str = f.read()
print(str)
f.close()
'''

# import pickle
# data1 = {'a': [1, 2.0, 3, 4 + 6j],
#          'b': ('string', u'Unicode string'),
#          'c': None}
# selfref_list = [1, 2, 3]
# selfref_list.append(selfref_list)
# output = open('E:\pythonworkspace\zhuzhu_输入和输出\序列化.pkl', 'wb')
# pickle.dump(data1, output)
# pickle.dump(selfref_list, output, -1)
# output.close()

# import pprint, pickle
# pk1_file = open('E:\pythonworkspace\zhuzhu_输入和输出\序列化.pkl', 'rb')
# data1 = pickle.load(pk1_file)
# pprint.pprint(data1)
# data2 = pickle.load(pk1_file)
# pprint.pprint(data2)
# pk1_file.close()

# from urllib import request
# # 打开网站
# response = request.urlopen("http://www.baidu.com/")
# # 打开存放数据的文件
# fi = open("E:\pythonworkspace\zhuzhu_输入和输出\爬虫.txt", 'w')
# # 往文件写入爬取的数据
# page = fi.write(str(response.read()))
# # 关闭流
# fi.close()

# a = input('请输入文字')
# print(a*2)

# a = int(input('请输入文字'))
# print(a*2)
# 注意默认6位小数
# print('%f' % 1.11)         # 默认保留6位小数1.110000
# print('%.1f' % 1.11)       # 取1位小数1.1
# print('%e' % 1.11)         # 默认6位小数，用科学计数法1.110000e+00
# print('%.3e' % 1.11)       # 取3位小数，用科学计数法1.110e+00
# print('%g' % 1111.1111)    # 默认6位有效数字1111.11
# print('%.7g' % 1111.1111)  # 取7位有效数字1111.111
# print('%.2g' % 1111.1111)  # 取2位有效数字，自动转换为科学计数法1.1e+03
# print('%s' % 'hello world')       # 字符串输出hello world
# print('%20s' % 'hello world')     # 右对齐，取20位，不够则补位         hello world
# print('%-20s' % 'hello world')    # 左对齐，取20位，不够则补位hello world
# print('%.2s' % 'hello world')     # 取2位he
# print('%10.2s' % 'hello world')   # 右对齐，取2位        he
# print('%-10.2s' % 'hello world')  # 左对齐，取2位he
