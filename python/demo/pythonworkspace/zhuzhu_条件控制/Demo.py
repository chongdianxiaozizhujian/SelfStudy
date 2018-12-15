a=5
# if(a==3):
#     print('a')
# else:
#     print('b')
# if(a==3):
#     print('a')
# elif(a==4):
#     print('b')
# else:
#     print('c')
# 猜谜小游戏
# number = 10
# guess = 0;
# while number != guess :
#     guess = int(input("请输入0~10之间的整数"))
#     if(guess < 0 or guess >10):
#         print("你输入的数超出范围")
#     elif(number > guess):
#         print("你输入的数小了")
#     elif(number < guess):
#         print("你输入的数大了")
#     else:
#         print("恭喜你猜对了")


# x 为 0-99 取一个数，y 为 0-199 取一个数,如果 x>y 则输出 x，如果 x 等于 y 则输出 x+y，否则输出y。

# import  random
# a = random.choice(range(100))
# b = random.choice(range(200))
# if(a > b):
#     print(a)
# elif(a==b):
#     print(a+b)
# else:
#     print(b)


# print("="*5,end='')
# print("welcome your coming to Dogs' years old system")
# print("="*5,end='')
# while True:
#     try:
#         age = int(input("please input dog's years old"))
#         print(" ")
#         age = float(age)
#         if(age <=0):
#             print("are you kidding me?")
#         elif(age == 1):
#             print("about 14 years old for people")
#             break
#         elif(age == 2):
#             print('about 22 years old for people')
#             break
#         else:
#             human = 22 + (age-2)*5
#             print('about ' + human + 'years old for people')
#             break
#     except ValueError:
#         print("the number you input is invalid， please input again")
# input("please input any key for exit")

