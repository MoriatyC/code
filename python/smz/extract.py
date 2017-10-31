# coding: UTF-8
from win32com import client as wc
import os
import re
import pywintypes
import db
BASE_DIR = os.path.dirname(__file__)
file_out = os.path.join(BASE_DIR, 'out/1.txt')
file_in = os.path.join(BASE_DIR, 'in/1.doc')


def extract(path):
    try:
        keys = []
        values = []
        # 打开word进程
        word = wc.Dispatch('Word.Application')
        # 打开相应的word文件
        doc = word.Documents.Open(path)
        # 将文件另存为文本
        doc.SaveAs(file_out, 4)
        with open(file_out) as f:
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
            string = ''.join(["insert into patient_information (",
                             "%s," * 18, "%s)values(", "'%s'," * 18, "'%s')"]) % template
            db.insert(string)
            # print string
    except pywintypes.com_error:
        pass
    finally:
        doc.Close()
        word.Quit()
if __name__ == '__main__':
    extract(file_in)

