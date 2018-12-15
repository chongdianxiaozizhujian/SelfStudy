# str = "abcdefg"
# print(str[0:5])
# print('\a')
# str1 = 'Hello'
# str2 = 'Python'
# print(str1 + str2)
# print(str1*2)
# print(str1[0])
# print(str1[0:2])
# print('H' in str1)
# print('H' in str2)
# print(r'/n')
# print('不到%s非好汉,%d' %('好汉',2018))
# print('%%')
# para_str = """这是一个多行字符串的实例
# 多行字符串可以使用制表符
# TAB ( \t )。
# 也可以使用换行符 [ \n ]。
# """
# print (para_str)
# 字符串首字母转换为大写
# print('hello'.capitalize())
# print('Hello'.capitalize())
# print('Hello'.center(40))
# print('Hello'.center(40,'*'))
# str='HelloHeHello'
# sub='H'
# print(str.count(sub))
# print((str.count(sub,0,5)))
# str='不到长城非好汉'
# print(str.encode('UTF-8').decode('UTF-8'))
# print(str.encode('GBK').decode('GBK','strict'))
# print(str.encode('gb2312'))
# str = 'hello'
# print(str.endswith('llo'))
# print(str.endswith('l',0,4))
# str = '\t\t hello \t py\t python \t \n \t hello'
# print(str.expandtabs(2));
# str='hello'
# print(str.find('l'))
# print(str.find('l',0,1))
# print(str.find('h',0,1))
# print(str.find('e',1,2))
# print(str.index('w'))
# str ='hello__hello'
# print(str.isalpha())
# str1 ='hello'
# print(str1.isalpha())
# str = 'hello'
# print(str.rfind('h'))
# print(str.title())
# 0、a,b为参数。从字符串指针为a的地方开始截取字符，到b的前一个位置（因为不包含b）
# var1 = "hello world";

# 1、如果a,b均不填写，默认取全部字符。即，下面这两个打印结果是一样的
# print(var1[: ]);  # hello world
# print(var1);      # hello world

# 2、如果a填写，b不填写（或填写的值大于指针下标），默认从a开始截取，至字符串最后一个位置
# print(var1[3: ]); # lo world

# 3、如果a不填写， b填写，默认从0位置开始截取，至b的前一个位置
# print(var1[: 8]); # hello wo

# 4、如果a为负数，默认从尾部某一位置，开始向后截取
# print(var1[-3: ]); # ld

# 5、如果a>=b, 默认输出为空。
# print(var1[3: 3]);
# print(var1[3: 2]);
# str = 10
# print('this is %o' %(str))
# print(bin((str)))
# L=['a','b','c','d','e','f','g']
# print(L[::2])
# str = 'hello good python'
# print(str.partition('goo'))
# print(str.partition('abc'))
from collections import Counter
str1='1121216464646464613121212'
str2='5648461231652236'
print(Counter(str1))
print(Counter(str2))