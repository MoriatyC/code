# -*- coding: utf-8 -*-
import MySQLdb as My
conn = My.connect(db='Medical_Information', host='192.168.2.79', user='root', passwd='root', charset='utf8')
cur = conn.cursor()
string = 'insert into patient_information values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)'
print string

if cur.execute(string, ('才', '才', 'a', 'a', 'a', 'a', 'a','a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a','a', 'a', 'a', 211)):
    print '插入成功'
else:
    print '插入失败'
cur.close()
conn.commit()
conn.close()


def show():
    # string = 'insert into patient_information values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)'
    cur.execute("select * from patient_information")
    for i in cur.fetchall():
        print i
if __name__ == '__main__':
    pass
