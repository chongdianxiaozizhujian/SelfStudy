'''
E:\findpyfile\demo.py  demo2.py  demo3.py
检索指定路径下后缀是py的所有文件
'''
import os
import os.path
ls = []
def getFile(path,ls):
    fileList = os.listdir(path)
    try:
        for temp in fileList:
            pathTemp = os.path.join(path, temp)
            if True == os.path.isdir(pathTemp):
                getFile(path,ls)
            elif pathTemp[pathTemp.rfind('.')+1:].upper()=="PY":
                ls.append(pathTemp)
    except PermissionError:
        pass

def main():
    while True:
        path = input("请输入路径:").strip()
        if os.path.isdir(path) == True:
            break
    getFile(path,ls)
    print(ls)
    print(len(ls))

main()