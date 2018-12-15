#行与缩进
'''
缩进不一致,会导致运行报错
'''
# a = True
# if a is True:
#     print("True")
# else:
# print("False")

b = False
if b is True: #判断使用is
    print("True")
else:
    print("False")

total = ['item_one', 'item_two', 'item_three',
         'item_four', 'item_five']
print(total)
total2 = 3 + \
        2 + \
        5
print(total2)

a = int(3) #声明
#a = (int)(3) 没问题
#a = int(3)
#a = int 3 有问题
#a = (int)3 有问题
print(a)
c = bool(True)
print(c)

d = complex(1 + 2j)
print(d)

#word = '字符串'
#word = "字符串"
word = """字符串
,字符串"""
print(word)
#str = 'hello\npython'
#str = r'hello\npython'
#str = "this" "is" "string"
#str = "hello"*2
#str = "hello" + "python"
str = "helloooooooo"
print(str[0:-1])# 输出第一个到倒数第二个的所有字符
print(str[0])# 输出字符串第一个字符
print(str[2:5])# 输出从第三个开始(0 1 2)到第五个(1 2 3 4 5)的字符 这个地方感觉python设计的有问题
print(str[2:])# 输出从第三个开始的后的所有字符
print(str)
input("\n\n 按住enter键")
input()
# import  sys; x = 'hellopython'; sys.stdout.write(x + '\n') #同一行显示多条语句
print(2018, end = "")
print(2017, end = '''''')
print(2020, end = """""")
print(2019, end = '') # 默认print是自动换行的,不换行则使用end = ""或者 end = ''等
# import sys
# for i in sys.argv:
#     print(i)
# print(sys.path)
from sys import path
print(path)