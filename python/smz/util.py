# coding: UTF-8
from win32com import client as wc
import os
import pywintypes


def get_string(fin='1.doc'):
    try:
        BASE_DIR = os.path.dirname(__file__)
        file_in = 'in/' + fin
        file_out = 'out/1.txt'
        file_out = os.path.join(BASE_DIR, file_out)
        file_in = os.path.join(BASE_DIR, file_in)
        # 打开word进程
        word = wc.Dispatch('Word.Application')
        # 打开相应的word文件
        path = file_in
        doc = word.Documents.Open(path)
        # 将文件另存为文本
        doc.SaveAs(file_out, 4)
        with open(file_out) as f:
            # 用GBK重新解码,在用UTF-8编码转换成str格式进行字符搜索
            text = f.read().decode('gbk')
            return text

    except pywintypes.com_error:
        pass
    finally:
        doc.Close()
        word.Quit()
if __name__ == '__main__':
    get_string()

