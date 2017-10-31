# coding: UTF-8
from util import *
import jieba
import sys

reload(sys)
sys.setdefaultencoding('utf-8')
s = get_string()
ret = ''
BASE_DIR = os.path.dirname(__file__)
file_out = os.path.join(BASE_DIR, 'out/result.txt')
file_out1 = os.path.join(BASE_DIR, 'out/final_result.txt')
with open(file_out, 'w') as f:
    for word in jieba.cut(s):
        ret += word + '\n'
        f.write(word + '\n')


def stop_word(segs_list):
    stopwords = [line.strip().decode('gb2312', 'ignore') for line in open('stop_words.txt')]
    final_list = []
    for seg in segs_list:
        if seg not in stopwords:
            final_list.append(seg)
    with open(file_out1, 'w') as f:
        f.write(' '.join(final_list))


stop_word(ret)
print '---------------------------------------------'