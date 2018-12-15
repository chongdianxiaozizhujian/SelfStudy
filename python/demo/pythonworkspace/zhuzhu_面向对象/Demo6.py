class Vector:
    def __init__(self, a, b):
        self.a = a
        self.b = b

    # 如果注释__str__(self)方法,会打印出 类似 <__main__.Vector object at 0x0000000000A7CF60>
    def __str__(self):
        return 'Vector (%d, %d)' % (self.a, self.b)

    def __add__(self, other):
        return Vector(self.a + other.a, self.b + other.b)


v1 = Vector(2, 10)
v2 = Vector(5, -2)
print(v1 + v2)