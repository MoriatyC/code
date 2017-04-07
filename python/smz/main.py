# coding: UTF-8
from util import *
import jieba
s = get_string('2.doc')
ret = ''
BASE_DIR = os.path.dirname(__file__)

file_out = os.path.join(BASE_DIR, 'out/result.txt')
with open(file_out, 'w') as f:
    for word in jieba.cut(s):
        f.write("      " + word.encode('UTF-8'))
