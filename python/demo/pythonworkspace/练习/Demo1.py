# 输出结果 4
# a = 1
# try:
#     a += 1
# except:
#     a += 1
# else:
#     a += 1
# finally:
#     a += 1
# print(a)
##################################
'''
import copy
a = [1, 2, 3, 4, ['a', 'b']]
b = a # 引用,a变则b变,b变则a变
c = copy.copy(a)  # 浅复制,会创建新的对象,但是会使用原对象原始元素的引用(内存地址),即c[i] is a[i],but c is not a
d = copy.deepcopy(a)  # 深复制,会创建新的对象 d is not a and d[i] is not a[i]
a.append(5)
a[4].append('c')
print(a)
print(b)
print(c)
print(d)
'''
################################
# 输出结果 __main__
# class Person:
#     def __init__(self):
#         pass
#     def getAge(self):
#         print(__name__)
#
# p = Person()
# p.getAge()
###############################
# 结果 5
# import math
# print(math.floor(5.5)) #向下取整 在python2版本答案为 5.0
###############################
'''
range 语法
range(start, end[, step])
参数说明:
start:计数从start开始,默认从0开始,例如 range(5) <==> range(0,5) --> 0 1 2 3 4
end:计数到end结束,但不包括end.
step:步长,默认为1. 例如 range(0,5) <==> range(0,5,1)
'''

# for i in range(2):
#  print(i)
# for i in range(4,6):
#  print(i)

#######################################

'''
ASCII码中小写字母>大写字母>数字
'''
# print(('A','B')<('a','A'))
'''
Python2 中除法默认向下取整，因此 1/2 = 0，为整型。
Python3 中的除法为正常除法，会保留小数位，因此 1/2 = 0.5，为浮点型。
'''
# print(0**0) 结果:1,任何数的0次方都为1
# print((-1)**0)
# print(1.2-1.0) Python中浮点数的运算存在误差,无法精确表示
'''
有一段python的编码程序如下：urllib.quote(line.decode("gbk").encode("utf-16")),经过该编码的字符串的解码顺序是
url解码	 utf16	gbk
解释
字符串编译的过程：gbk==>unicode==>utf16==>url解码
字符串解码顺序为：url解码==>utf16==>unicode==>gbk
'''
'''
----------------------------------第一次刷python题 50% ---------------------------
'''
