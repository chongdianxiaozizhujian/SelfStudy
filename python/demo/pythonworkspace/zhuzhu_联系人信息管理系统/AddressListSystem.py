import os
import pickle
datafile = 'person.data'
# 打印操作指令
def printOper():

    message = '''
    Welcome bookmark:
    \tpress 1 to show list
    \tpress 2 to add pepole
    \tpress 3 to edit pepole
    \tpress 4 to delete pepole
    \tpress 5 to search pepole
    \tpress 6 to show menu
    \tpress 0 to quit
    '''
    print('=' * 70)
    print(message)
    print('=' * 70)

'''通讯录联系人'''
class Person(object):
    def __init__(self, name, number):
        self.name = name
        self.number = number

# 获取数据
def get_data(filename=datafile):
    # 文件存在且不为空
    if os.path.exists(filename) and os.path.getsize(filename):
        with open(filename,'rb') as f:
            return pickle.load(f)
    return None

# 写入数据
def set_data(name, number, filename=datafile):
    personList = {} if get_data() == None else get_data()
    with open(filename,'wb') as f:
        personList[name] = Person(name, number)
        pickle.dump(personList,f)

# 保存字典格式的数据到文件
def save_data(dictPerson, filename=datafile):
    with open(filename,'wb') as f:
        pickle.dump(dictPerson,f)
# 显示所有联系人
def show_all():
    personList = get_data()
    if personList:
        for v in personList.values():
            print(v.name, v.number)
        print('='*70)
    else:
        print('not yet person, please add person')
        print('='*70)
# 添加联系人
def add_person(name, number):
    set_data(name, number)
    print('success add person')
    print('='*70)
# 编辑联系人
def edit_person(name, number):
    personList = get_data()
    if personList:
        personList[name] = Person(name,number)
        save_data(personList)
        print('success edit person')
        print('='*70)

# 删除联系人
def delete_person(name):
    personList = get_data()
    if personList:
        if name in personList:
            del personList[name]
            save_data(personList)
            print('success delete person')
        else:
            print(name, ' is not exists in dict')
        print('='*70)

# 搜索联系人
def search_person(name):
    personList = get_data()
    if personList:
        if name in personList.keys():
            print(personList.get(name).name,personList.get(name).number)
        else:
            print('No this person of', name)
        print('='*70)
printOper()
# 不同的操作指令对应具体的操作
while True:
    num = input('>>')
    if num == '1':
        # print('show all personList:')
        show_all()
    elif num == '2':
        # print('add person:')
        name = input('input name>>')
        number = input('input number>>')
        add_person(name, number)
    elif num == '3':
        # print('edit person:')
        name = input('input name>>')
        number = input('input number>>')
        edit_person(name, number)
    elif num == '4':
        # print('delete person:')
        name = input('input name>>')
        delete_person(name)
    elif num == '5':
        # print('search:')
        name = input('input name>>')
        search_person(name)
    elif num == '6':
        # print('show menu:')
        printOper()
    elif num == '0':
        break
    else:
        print('input error, please retry')

