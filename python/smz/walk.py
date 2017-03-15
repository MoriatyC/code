# coding:UTF-8
import extract
import os.path
file_path = 'C:/1'
try:
    for (dirpath, dirnames, filename) in os.walk(file_path):
        for i in range(len(filename)):
            current_path = os.path.join(dirpath.decode('gbk'), filename[i].decode('gbk'))
            extract.extract(current_path)
except Exception, e:
    print e
finally:
    extract.db.cur.close()
    extract.db.conn.close()
if __name__ == "__main__":
    pass