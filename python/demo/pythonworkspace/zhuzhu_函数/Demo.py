# def printDemo(a):
#     print(a)
#     return a
#
# b = printDemo('你好')
# print(b)
# 可写函数说明
# def changeme(mylist):
#     "修改传入的列表"
#     mylist.append([1, 2, 3, 4]);
#     print("函数内取值: ", mylist)
#     return
#
#
# # 调用changeme函数
# mylist = [10, 20, 30];
# changeme(mylist);
# print("函数外取值: ", mylist)

# def paramDemo(name, age = '5', hobby = '6'):
#     print(name)
#     print(age)
#     print(hobby)
#
#
# paramDemo(age = '2', name = '1')
# paramDemo(name = '2')
#
# def paramDemo1(name , age = '5'):
#     print(name)
#     print(age)
# def printInfo(abc, *bc):
#     print(abc)
#     for x in bc:
#         print(x)
#     return;
# printInfo(10,20,50,60)
# 可写函数说明
# sum = lambda arg1, arg2: arg1 + arg2;
#
# # 调用sum函数
# print("相加后的值为 : ", sum(10, 20))
# print("相加后的值为 : ", sum(20, 20))

# mul = lambda a,b:a*b
# print(mul(3,4))
# num = 1
# def fun1():
#     global num  # 需要使用 global 关键字声明
#     print(num)
#     num = 123
#     print(num)
# fun1()
# def outer():
#     num = 10
#     def inner():
#         nonlocal num   # nonlocal关键字声明
#         num = 100
#         print(num)
#     inner()
#     print(num)
# outer()
# 运行结果
# china sichuan {'section': 'jingjiang', 'city': 'chengdu'}
# def func(country,province,**kwargs):
#     print(country, province, kwargs)
#
# func('china','sichuan',city = 'chengdu',section= 'jingjiang')
# g= lambda x,y : x**3+y**2
# print(g(2,3))
# print(g(y=3,x=4))
# 可写函数说明
# def changeme(mylist):
#     "修改传入的列表"
#     # mylist = [1, 2, 3, 4];
#     # mylist.append('5');
#     mylist.append(5)
#     mylist=[1,2,3]
#     mylist.append(6)
#     print("函数内取值: ", mylist)
#     return


# 调用changeme函数
# mylist = [10, 20, 30];
# changeme(mylist);
# print("函数外取值: ", mylist)
# import builtins
# for x in dir(builtins):
#     print(x)
#
# print(len(dir(builtins)))