# coding: UTF-8
def show():
    print '-' * 60
    for i in range(2):
        if i == 1:
            print '|','%45s'%'简易学生管理系统','%23s' % '|'
        print  '|','%58s' % '|'
    print '-' * 60
    print '*' * 60
    print '%10s' % ' ','%-15s' % '1.新增学生','%15s' % ' ','2.查询学生信息'
    print '%10s' % ' ', '%-15s' % '3.修改学生信息', '%13s' % ' ', '4.删除学生信息'
    print '%10s' % ' ', '%-15s' % '5.退出'
    while True:
        try:
            choice = raw_input("请输入想要使用的功能：")
            func = dic[choice]
            func()
        except KeyError:
            print '请输入正确的功能号'

def search_by_id(id):
    for line in open('db.txt'):
        target = line.split()[0]
        if target == id:
            print line
            return 1
            break
    else:
        return 0
        print '没有此人'

def search_by_name(name):
    count = 0
    for line in open('db.txt'):
        target = line.split()[1]
        if target == name:
            print line
            count += 1
    if not count:
        print '没有此人'

def add():
    print '请按要求输入相关信息'
    while True:
        stuId = raw_input('学生学号:')
        if not search_by_id(stuId):
            break
        print '已存在该学号的学生'
    name = raw_input('学生姓名:')
    sex = raw_input('学生性别(M|F):')
    while sex.upper() not in ('M','F'):
        sex = raw_input('请输入正确的性别:')
    age = raw_input('年龄:')
    math = input('数学成绩(0-150):')
    while math < 0 or math > 150:
        math = raw_input('成绩错误，请重新输入')
    message = str(stuId),str(name),sex,age,str(math),'\n'
    message = ' '.join(message)
    with open('db.txt','a+') as file:
        file.write(message)
    while True:
        behave = raw_input('是否继续添加（Y/N)')
        if behave.lower() == 'y':
            func = dic['1']
            break
        elif behave.lower() == 'n':
            func = dic['0']
            break
        else:
            print '请选择正确的下一步操作'
    func()


def search():
    id = None
    name = None
    while True:
        method = raw_input('按学号搜索请按1，按姓名姓名请按2')
        if method in ('1','2'):
            break
    if method == '1':
        id = raw_input('请输入学号')
        search_by_id(id)
    if method == '2':
        name = raw_input('请输入姓名')
        search_by_name(name)
def delete_line(id):
    seek_line = 0
    current_line = 1
    with open('db.txt') as fre:
        with open('db.txt','r+b') as frw:
            with open('db.txt') as temp:
                for line in temp:
                    seek_line += 1
                    if id == line.split()[0]:
                        break
                while current_line < seek_line:
                    current_line += 1
                    fre.readline()
                position = fre.tell()
                fre.readline()
                frw.seek(position,0)
                str = fre.readline()
                while str:
                    frw.write(str)
                    str = fre.readline()
                frw.truncate()
def modify():
    id = raw_input('请输入将修改学生的好号')
    if search_by_id(id):
        delete_line(id)
        add()
    else:
        print '没有此人，无法进行修改'
def delete():
    id = raw_input('请输入将删除学生的学号')
    if search_by_id(id):
        delete_line(id)
    else:
        print "没有此学生"
dic = {'0':show,'1': add,'2':search,'3':modify,'4': delete,'5':exit}
if __name__ == '__main__':
    show()

