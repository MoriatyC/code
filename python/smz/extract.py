# coding: UTF-8
from win32com import client as wc
import os
import re
import pywintypes
import db
keys = []
values = []
BASE_DIR = os.path.dirname(__file__)
file_in = os.path.join(BASE_DIR, 'in/1.doc')
file_out = os.path.join(BASE_DIR, 'out/1.txt')
try:
    # 打开word进程
    word = wc.Dispatch('Word.Application')
    # 打开相应的word文件
    doc = word.Documents.Open(file_in)
    # 将文件另存为文本
    doc.SaveAs(file_out, 4)
    f = open(file_out)
    # 用GBK重新解码,在用UTF-8编码转换成str格式进行字符搜索
    text = f.read().decode('gbk').encode('utf-8')
    pat = re.compile(r'(\s\S*?)：(\s\S*)')
    ret = pat.findall(text)
    for i in range(16):
        keys.append(ret[i][0].strip())
        values.append(ret[i][1].strip())
    progress_note = re.compile(r'入院诊断：([\s\S]*?)出院诊断：([\s\S]*?)病程记录([\s\S]*)')
    keys.append('入院诊断')
    keys.append('出院诊断')
    keys.append('病程记录')
    ret_note = progress_note.search(text)
    if ret_note:
        values.append(ret_note.group(1).strip())
        values.append(ret_note.group(2).strip())
        values.append(ret_note.group(3).strip())
    else:
        print 'ret_note search failed'
    keys.extend(values)
    template = tuple(keys)
    string = "insert into patient_information " \
             "(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)values" \
             "('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s'," \
             "'%s','%s','%s','%s','%s')" % template
    db.insert(string)
except pywintypes.com_error:
    pass
finally:
    doc.Close()
    word.Quit()

