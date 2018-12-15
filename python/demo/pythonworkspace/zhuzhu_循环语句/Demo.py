# while 来计算 1 到 100 的总和
# sum = 0
# n = 100
# counter = 1
# while counter <= n:
#     sum += counter
#     counter += 1
# print(sum)
# a = 5
# while a==5 :
#     print('a==5')
#     a = a+1
# else:
#     print('a!=5')
# languages = ['a','b','c']
# for x in languages:
#     print(x)
# tupleDemo = (1,2,3)
# for y in tupleDemo:
#     print(y)
# list = [1,2,3]
# for x in list:
#     if(x==2):
#         print(x)
#         break
#     else:
#         print(x)
# list = [1,2,3,4]
# for x in range(len(list)):
#     print(x,list[x])
# sequence = [1,2,3,4,5,6,7,8,9]
# for index, item in enumerate(sequence):
#     print(index, item)
# 9*9乘法表
# i=1
# while i <=9:
#     j=1
#     while(j<=i):
#         mut = j*i
#         print('%d*%d=%d'%(j,i,mut),end=' ')
#         j+=1
#     print('')
#     i+=1

# a = 1
# while a < 6:
#     for x in range(1,a):
#         print('*',end='')
#     print('')
#     a+=1
'''
print(sum(range(101)))
print(range(10))
# print(sum(1.0, 2.0)) 报错
a = 10
b = 20
# print(sum()) 报错
'''

#十进制转化

# while True:
#     number = input('请输入一个整数(输入Q退出程序)：')
#     if number in ['q','Q']:
#         break                #如果输入的是q或Q,结束退出
#     elif not number.isdigit():
#         print('您的输入有误！只能输入整数(输入Q退出程序)！请重新输入')
#         continue         #如果输入的数字不是十进制,结束循环,重新开始
#     else :
#             number = int(number)
#             print('十进制 --> 十六进制 ：%d -> 0x%x' %(number,number))
#             print('十进制 -->   八进制 ：%d -> 0o%o' %(number,number))
#             print('十进制 -->   二进制 ：%d ->'%number,bin(number))


# python 冒泡排序
# def paixu(li):
#     max = 0
#     for a in range(len(li)-1):
#         for x in range(len(li)-1-a):
#             if li[x] > li[x+1]:
#                 max = li[x]
#                 li[x]=li[x+1]
#                 li[x+1]=max
#             else:
#                 max = li[x+1]
#     print(li)
#
# paixu([1,5,3,4])



