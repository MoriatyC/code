# -*- coding: utf-8 -*-
import MySQLdb as My
conn = My.connect(db='Medical_Information', host='192.168.2.79', port=3306, user='root', passwd='root', charset='utf8')
cur = conn.cursor()


def insert(string):
    try:
        cur.execute(string)
        print 20 * '*', '插入成功', '*' * 20
        conn.commit()
    except Exception, e:
        print e
        cur.close()
        conn.close()


def show():
    try:
        cur.execute("select * from patient_information")
        for i in cur.fetchall():
            print i
    except Exception, e:
        print e
    finally:
        cur.close()
        conn.commit()
        conn.close()


if __name__ == '__main__':
    show()



