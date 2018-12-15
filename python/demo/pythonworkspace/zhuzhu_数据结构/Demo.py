# listDemo = [];
# listEx = [2,3]
# print(type(listDemo))
# listDemo.append(1)
# listDemo.extend(listEx)
# listDemo.insert(1,5)
# listDemo.insert(1,5)
# listDemo.remove(5)
# print(listDemo)
# listDemo.pop()
# print(listDemo)
# listDemo.clear()
# print(listDemo)
# listDemo.insert(1,1)
# count = listDemo.count(1)
# print(count)
# listDemo.sort()
# print(listDemo)
# listDemo.reverse()
# print(listDemo)
# copy = listDemo.copy()
# copy.append(9)
# listDemo.append(10)
# copy[0]=11
# print(copy)
# print(listDemo)
# vec = [2, 4, 6]
# print(vec)
# vec = [3*x for x in vec]
# print(vec)
# vec = [[x, x**2] for x in vec]
# print(vec)
# freshfruit = ['  banana', '  loganberry ', 'passion fruit  ']
# print(freshfruit)
# freshfruit = [weapon.strip() for weapon in freshfruit]
# print(freshfruit)
# vec = [2,4,6]
# print(vec)
# vec = [x*2 for x in vec if x > 3]
# print(vec)
# vec1 = [2,4,6]
# vec2 = [-2,-4,-6]
# vec = [x*y for x in vec1 for y in vec2]
# print(vec)
# vec3 = [vec1[i]*vec2[i] for i in range(len(vec1))]
# print(vec3)
# for i in range(1, 6):
#     print(i)
# m = [
#     [1,2,3,4],
#     [1,2,3,4],
#     [1,2,3,4]
# ]
#
# m = [[x[i] for x in m] for i in range(4)]
# print(m)
# a = [-1, 1, 66.25, 333, 333, 1234.5]
# print(a)
# del a
# print(a) # 会报错,因为已经删除了实体变量

# t = 1,2,3
# print(type(t))
# m = (1,2,3)
# print(type(m))
# a = {x for x in 'abracadabra' if x not in 'abc'}
# print(a)
# knights = {'gallahad': 'the pure', 'robin': 'the brave'}
# for k, v in knights.items():
#     print(k, v)
# for i, v in enumerate(['tic', 'tac', 'toe']):
#     print(i, v)
# a = {'a':'1','b':'2'}
# for k,v in a.items():
#     print(k + '---' + v)
# a = {'a':1,'b':2}
# for k,v in a.items():
#     # v = bytes(v) 报错
#     print(k + '---' + str(v))
# a = {'a':1,'b':2}
# for k,v in a.items():
#     print(k + '---' + v) # 报错 TypeError: Can't convert 'int' object to str implicitly
# a = [1,2,3,'abc','def']
# for i, v in enumerate(a):
#     print(i,v)
# questions = ['1+1=','2+2=','3+3=']
# answers = [2,4,6]
# for q, a in zip(questions,answers):
#     print('{0}{1}.'.format(q,a))
# for i in reversed(range(1,10,3)):
#     print(i)
# basket = ['apple', 'orange', 'apple', 'pear', 'orange', 'banana']
# for f in sorted(set(basket)):
#     print(f)
# a = [1,1,2,9,2,3,5,6,1,4]
# for i in sorted(set(a)):
#     print(i)
# for x in range(1,5):
#     if x > 2:
#         for y in range(1,4):
#             if y < 3:
#                 print(x*y)
# a = [x*y for x in range(1,5) if x > 2 for y in range(1,4) if y < 3]
# print(a)
m = [
    [1,2,3,4],
    [1,2,3,4],
    [1,2,3,4]
]
n = [row[i] for i in range(4) for row in m]
print(n)