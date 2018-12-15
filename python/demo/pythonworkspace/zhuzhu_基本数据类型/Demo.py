# a=b=c=d=1
# print(a)
# print(b)
# print(c)
# print(d)
# a,b,c=1,2,'a'
# print(a)
# print(b)
# print(c)
# a,b,c,d = 1,1.2,True,2+1j
# print(type(a))
# print(type(b))
# print(type(c))
# print(type(d))
# print(isinstance(a, int))
# print(isinstance(a, float))
# class A:
#     pass
# class B(A):
#     pass
# print(isinstance(A(), A))
# print(type(A()) == A)
# print(isinstance(B(), A))
# print(type(B()) == A)
# b = 1
# a = 2
# del b
# print(b) # 删除对象后,此句会报错
# print(a)
# print(2)
# print(2//4)
# print(2/4)
# word = "abcdefg"
# # word[0] = "a" 字符串不能被改变
# print(word)
# list = ['abcd', 786, 2.23, 'runoob', 70.2]
# tinylist = [123, 'runoob']
# print(list)  # 输出完整列表
# print(list[0])  # 输出列表第一个元素 abcd
# print(list[1:3])  # 从第二个开始输出到第三个元素 [786,2.23]
# print(list[2:])  # 输出从第三个元素开始的所有元素[2.23,'runoob',70.2]
# print(tinylist * 2)  # 输出两次列表 [123, 'runoob', 123, 'runoob']
# print(list + tinylist)  # 连接列表
# a = (1,2,3)
# print(type(a) == tuple)
# b = (1,2,3)
# b[1] = 0 元组数据不能被更改

# c = ([5,6],2,3)
# c[0][0] = [8,[9]]
# print(c)
# d = (1,)
# print(type(d) == tuple)
# e = ("4")
# print(type(e) == tuple)
# print(type(e))
# a = {1,2,2,2,2,2}
# print(a)
# # b = set(1,2,2,2,2,3) 此种设置方式错误
# b = set('12222223333')
# # c = set(1222) 此种设置方式错误
# print(b)
# if('2' in b):
#     print("yes")
# else:
#     print("no")
# a = set('abracadabra')
# b = set('alacazam')
# print(a)
# print(b)
# print(a - b)  # a和b的差集
# print(a | b)  # a和b的并集
# print(a & b)  # a和b的交集
# print(a ^ b)  # a和b中不同时存在的元素
# a = {}
# a['12'] = 2
# a[2] = 3
# print(a[2])
# print(a['12'])
# b = {2:"abc",3:"def",4:3}
# print(b[2])
# print(b[3])
# print(b[4])
# print(b.keys())
# print(b.values())
# print(dict([("abc",1),(3,2)]))
# b = dict([(1,2),(3,4)])
# print(b)
# print({x: x**2 for x in (2, 4, 6)})
# c = dict(Runoob=1, Google=2, Taobao=3)
# print(c)
# def example(a,b):
#     return dict([(a,b)])
# print(type(example(1,2)))
# def test(*args):
#     print(args)
#     return args
# print(type(test(1,2,3,4)))
# def example(d):
#     for c in d:
#         # print(c)
#         # print(d[c])
#         print(c,':',d[c])
# d = dict(a = 1, b = 2)
# example(d)
# list = ['abcd',123,12,'ef']
# print(list[1:3])# 从第二个开始输出到第三个元素 list[1:3] 其实输出的只有两个变量，即list中第二个元素到第三个元素
# print(list[2])
# print(list[2:3])


# class father(object):
#     pass
#
#
# class son(father):
#     pass
# if __name__ == '__main__':
#     print(type(son()) == father)
#     print(isinstance(son(),father))
#     print(type(son()))
#     print(type(son))
# dict1 = {'abc':1,'ab':'ab',2:'cd'}
# dict1 = dict([('a',1),('b',2),('c',3)])
# for k,v in dict1.items():
#     print(k,":",v)
# dict2 = dict((('a',1),('b',2)))
# for k,v in dict2.items():
#     print(k,":",v)
# print(type(((('a',1)))))
# print(type(dict((('a',1),('b',2)))))
# print(type(dict((('a',1),))))
# 元素为元组的列表
#dict_ = dict([(1,2)])
# 元素为元组的集合
# dict_ = dict({(1,2)})
# 元素为列表的列表
# dict_ = dict([[1,2]])
#元素为元组的元组
# dict_ = dict(((1,2))) 只有一个元素的元组的元组不能这样作为创建字典的参数
# dict_ = dict(((1,2),)) # 应该以,分割
# print(type(dict_))
# for k,v in dict_.items():
#     print(k,":",v)
class Complex(object):
    def __init__(self,rel=15,img=15j):
        self.realPart = rel
        self.imagPart = img
    def creatComplex(self):
        return self.realPart + self.imagPart
    def getImg(self):
        img = str(self.imagPart)
        img = img[:-1];
        return  float(img)

def test():
    com = Complex()
    Cplex = com.creatComplex()
    if Cplex.imag == com.getImg():
        print(com.getImg())
    else:
        pass
    if Cplex.real == com.realPart:
        print(com.realPart)
    else:
        pass
    print(Cplex)
    print(Cplex.conjugate())
if __name__=="__main__":
    test()









