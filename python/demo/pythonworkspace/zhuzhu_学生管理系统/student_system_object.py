class StudentSys(object):
    def __init__(self):
        #全局变量,每个函数都可以修改
        self.students = []#列表[字典]
    def print_menu(self):
        "打印程序功能信息"
        print('='*50)
        print("\t~学生管理系统1.0版本~")
        print("\t1:添加学生信息")
        print("\t2:删除学生信息")
        print("\t3:修改学生信息")
        print("\t4:查找学生信息")
        print("\t5:显示学生信息")
        print("\t6:退出学生信息系统")
        print('='*50)
        print('\n')

    def add_info(self):
        "添加学生信息"
        # global students
        student = {}#空的字典
        name = input("请输入要添加的学生的姓名:")
        phone = input("请输入要添加的学生的电话:")
        wechat = input("请输入要添加的学生的微信:")
        #往字典添加数据
        student["name"] = name
        student["phone"] = phone
        student["wechat"] = wechat
        #把字典添加到列表中
        #students.insert(0, student)#添加数据到列表的开头
        self.students.append(student)#添加数据到列表的末尾
        #打印信息
        #print(students)
        self.show_info()


    def show_info(self):
        "以表格的方式显示信息"
        print("\n")
        print("\t\t当前学生信息")
        print("-" * 70)
        print("\t姓名\t\t电话\t\t微信\t")
        for student in self.students:
            print("-" * 70)
            # 字典
            print("\t" + student["name"] + "\t\t" + student["phone"] + "\t\t" + student["wechat"] + "\t")
        print("-" * 70)
        print("\n")

    def delete_info(self):
        "删除学生信息"
        # global  students
        name = input("请输入您要删除的学生姓名")
        for student in self.students:
            if name == student.get("name"):
                #列表删除信息
                self.students.remove(student)
        self.show_info()

    def modify_info(self):
        "修改学生信息"
        name = input("请输入要修改学生的姓名")
        # global students
        for student in self.students:
            if name == student.get("name"):
                new_name = input("请输入新的名字")
                student["name"] = new_name
        self.show_info()

    def find_info(self):
        "查找学生信息"
        name = input("请输入要查找学生姓名")
        flag = 0 #所有的都找了,就是不存在 1 只要找到一个就算找到
        # global  students
        for student in self.students:
            if name == student.get("name"):
                print("已经找到[%s]" % name)
                flag = 1
            # else:
            #     print("没有找到[%s]" % name)
        if flag == 0:
            print("没有找到[%s]" % name)

    # 保存信息 增加、删除、修改
    def save_info(self):
        # global students
        f = open("students_object.txt","w")#每次保存都会覆盖
        f.write(str(self.students))
        f.close()

    # 读取信息:运行时候
    def load_info(self):
        # global students
        f = open("students_object.txt", "a+")  # 每次保存都会覆盖
        f.seek(0)
        content = f.read()
        if len(content) > 0:
            self.students = eval(content)
        f.close()
    # 定义一个入口函数
    def main(self):
        self.print_menu()
        self.load_info()
        print("\n")
        while True:
            print('\t\t操作指令')
            print('-' * 50)
            infos = "1:增加|2:删除|3:修改|4:查找|5:显示|6:退出系统"
            print(infos)
            print('-' * 50)
            num = input("请按照上面的提示输入相应的指令:")

            #判断用户输入的内容
            if num == "1":
                # print("增加")
                self.add_info()
                self.save_info()
            elif num == "2":
                # print("删除")
                self.delete_info()
                self.save_info()
            elif num == "3":
                # print("修改")
                self.modify_info()
                self.save_info()
            elif num == "4":
                # print("查找")
                self.find_info()
            elif num == "5":
                #print("显示")
                self.show_info()
            elif num == "6":
                print("退出")
                break
# 创建实例对象
StudentSys().main()