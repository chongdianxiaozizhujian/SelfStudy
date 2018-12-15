# tup = "a","b","c"
# print(type(tup))
import collections
User = collections.namedtuple('User','name age id')
user = User('Tom','21','1')
print(user)