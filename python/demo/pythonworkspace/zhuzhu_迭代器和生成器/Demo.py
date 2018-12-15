# list = [1,2,3,4]
# it = iter(list)
# print(next(it))
# print(next(it))
# for x in it:
#     print(x)
# import sys
# list = [1,2,3,4]
# it = iter(list)
# while True:
#     try:
#         print(next(it))
#     except StopIteration:
#         sys.exit()
# import sys
#
#
# def fibonacci(n):  # 生成器函数 - 斐波那契
#     a, b, counter = 0, 1, 0
#     while True:
#         if (counter > n):
#             return
#         yield a
#         a, b = b, a + b
#         counter += 1
#
#
# f = fibonacci(10)  # f 是一个迭代器，由生成器返回生成
#
# while True:
#     try:
#         print(next(f), end=" ")
#     except StopIteration:
#         sys.exit()
# import sys
#
# def fibonacci(n,w=0): # 生成器函数 - 斐波那契
#     a, b, counter = 0, 1, 0
#     while True:
#         if (counter > n):
#             return
#         # yield a
#         a, b = b, a + b
#         print('%d,%d' % (a,b))
#         counter += 1
# f = fibonacci(10,0) # f 是一个迭代器，由生成器返回生成
#
# while True:
#     try:
#         print (next(f), end=" ")
#     except :
#         sys.exit()
# import  sys
# def fab(max):
#    n, a, b = 0, 0, 1
#    L = []
#    while n < max:
#        L.append(b)
#        a, b = b, a + b
#        n = n + 1
#    return L
# print(fab(5))
#
# f = iter(fab(10))
# while True:
#     try:
#         print(next(f), end=" ")
#     except StopIteration:
#         sys.exit()
# import  sys
# def fab(max):
#     n, a, b = 0, 0, 1
#     while n < max:
#         yield b
#         # print b
#         a, b = b, a + b
#         n = n + 1
#
# for x in fab(5):
#     print(x)
# f = fab(5)
# while True:
#     try:
#         print (next(f), end=" ")
#     except :
#         sys.exit()
# def get():
#     m = 0
#     n = 2
#     l = ['s', 1, 3]
#     k = {1: 1, 2: 2}
#     p = ('2', 's', 't')
#     while True:
#         m += 1
#         yield m
#         yield m, n, l, k, p
#
#
# it = get()
# print(next(it))  # 1
# print(next(it))  # (1, 2, ['s', 1, 3], {1: 1, 2: 2}, ('2', 's', 't'))
#
# print(next(it))  # 2
# print(type(next(it)))  # <class 'tuple'>
