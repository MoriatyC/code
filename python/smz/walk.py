# coding:UTF-8
import extract
import os.path
file_path = 'C:/1'
for (dirpath, dirnames, filename) in os.walk(file_path):
    for i in range(len(filename)):
        current_path = os.path.join(dirpath.decode('gbk'), filename[i].decode('gbk'))
        # print current_path
        # f = open(current_path)
        # t = f.read().decode('gbk')
        # print t
        extract.test(current_path)