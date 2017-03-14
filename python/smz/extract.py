# coding: UTF-8
from win32com import client as wc
import os
import re
import pywintypes
import db
BASE_DIR = os.path.dirname(__file__)
file_in = os.path.join(BASE_DIR, 'in/1.doc')
file_out = os.path.join(BASE_DIR, 'out/1.txt')
# 打开word进程
try:
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
        print str(i+1) + "  " + ret[i][0].strip() + ":" + ret[i][1].strip()
    progress_note = re.compile(r'入院诊断：([\s\S]*?)出院诊断：([\s\S]*?)病程记录([\s\S]*)')
    ret_note = progress_note.search(text)
    if ret_note:
        print ret_note.group(1).strip()
        print '='*100
        print ret_note.group(2).strip()
        print '+' * 100
        print ret_note.group(3).strip()
    else:
        print 'ret_note search failed'
    # if ret_name:
    #     print ret_name.group(1).strip()
    # else:
    #     print 'ret_name search failed'
    #
    # if ret_sex:
    #     print ret_sex.group(1).strip()
    # else:
    #     print 'ret_sex search failed'
    #
    # if ret_age:
    #     print ret_age.group(1).strip()
    # else:
    #     print 'ret_age search failed'
    #
    # if ret_nation:
    #     print ret_nation.group(1).strip()
    # else:
    #     print 'ret_nation search failed'
    #
    # if ret_career:
    #     print ret_career.group(1).strip()
    # else:
    #     print 'ret_career search failed'
    #
    # if ret_address:
    #     print ret_address.group(1).strip()
    # else:
    #     print 'ret_address search failed'
    #
    # if ret_hometown:
    #     print ret_hometown.group(1).strip()
    # else:
    #     print 'ret_hometown search failed'
    #
    # if ret_workplace:
    #     print ret_workplace.group(1).strip()
    # else:
    #     print 'ret_workplace search failed'
    #
    # if ret_marital_status:
    #     print ret_marital_status.group(1).strip()
    # else:
    #     print 'ret_marital_status search failed'
    #
    # if ret_admission_time:
    #     print ret_admission_time.group(1).strip()
    # else:
    #     print 'ret_admission_time search failed'
    #
    # if ret_chief_complaint:
    #     print ret_chief_complaint.group(1).strip()
    # else:
    #     print 'ret_chief_complaint search failed'
    #
    # if ret_history_of_present_illness:
    #     print ret_history_of_present_illness.group(1).strip()
    # else:
    #     print 'ret_history_of_present_illness search failed'
    #
    # if ret_past_history:
    #     print ret_past_history.group(1).strip()
    # else:
    #     print 'ret_past_history search failed'
    #
    # if ret_personal_history:
    #     print ret_personal_history.group(1).strip()
    # else:
    #     print 'ret_personal_history search failed'
    #
    # if ret_menstrual_history:
    #     print ret_menstrual_history.group(1).strip()
    # else:
    #     print 'ret_menstrual_history search failed'
    #
    # if ret_family_history:
    #     print ret_family_history.group(1).strip()
    # else:
    #     print 'ret_family_history search failed'
    #
    # if ret_physical_examination:
    #     print ret_physical_examination.group(1).strip()
    # else:
    #     print 'ret_physical_examination search failed'
    #
    # if ret_admitting_diagnosis:
    #     print ret_admitting_diagnosis.group(1).strip()
    # else:
    #     print 'ret_admitting_diagnosis search failed'
    #
    # if ret_discharge_diagnosis:
    #     print ret_discharge_diagnosis.group(1).strip()
    # else:
    #     print 'ret_discharge_diagnosis search failed'

    # if progress_note:
    #     print ret_progress_note.group()
    # else:
    #     print 'progress_note search failed'
except pywintypes.com_error:
    pass
finally:
    doc.Close()
    word.Quit()

