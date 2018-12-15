# print(len([1,2,3,4]))
# print([1,2,1,'abv'] + [2,1,2])
# print(['hi']*2)
# print(3 in [1,2,3])
# for x in [1,2,3]:
#     print(x,end='')
# list_2d = [[0 for col in range(cols)] for row in range(rows)]
# list_2d = [[1 for j in range(5)] for j in range(5)]
# print(list_2d)
import copy
a=[1,2,3]
b=a
c=[]
c=a
d=a[:]
e=copy.copy(a)
f=a.copy()
b[0]='a'
print(a)
print(b)
print(c)
print(d)
print(e)
print(f)
print(id(a))
print(id(b))
print(id(c))
print(id(d))
print(id(e))
print(id(f))
# import copy
#
# a = [1,2,3,4]
# b = a
# d = copy.copy(a)
# b[0] = 'b'
# print(a,b,d)
# print(id(a),id(b),id(d))


