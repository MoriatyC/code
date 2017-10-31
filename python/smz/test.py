import os

class a:
    x = 1
    def f(self):
        print self.x

class aa(a):
    x = 2
aaa = aa()
aaa.f()