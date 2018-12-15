# class MyClass:
#     i = 12345
#     def f(self):
#         return 'hello python'
# x=MyClass()
# print(x.i)
# print(x.f())
#
# class Complex:
#     def __init__(self, realpart, imagpart):
#         # self 代表类的实例,而非类
#         self.r = realpart
#         self.i = imagpart
# y=Complex(3.0,-4.5)
# print(y.r)
# print(y.i)
#
# class Test:
#     # self 代表的是类的实例，代表当前对象的地址，而 self.class 则指向类。
#     def prt(self):
#         print(self)
#         print(self.__class__)
# t=Test()
# t.prt()
class people:
    name=''
    age=0
    # 定义私有属性,私有属性在类外部无法直接进行访问
    __weight=0
    def __init__(self, n, a, w):
        self.name = n
        self.age = a
        self.__weight = w
    # 创建一个"公有方法"，在方法中，去调用"私有字段"
    def speak(self):
        print(self.name)
        print(self.age)
        print(self.__weight)

p = people('python', 10, 30)
print(p.name)
print(p.age)
# print(p.__weight) 这里调用不了类的私有属性
p.speak()