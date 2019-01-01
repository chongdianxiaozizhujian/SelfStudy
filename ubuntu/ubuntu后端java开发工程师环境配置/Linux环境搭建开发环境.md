##### Linux环境搭建开发环境

```java
1.安装jdk
1) 区分系统32/64位
uname -a
2) 卸载OpenJDK
java -version//查看是否安装的是OpenJDK
sudo apt-get purge openjdk-\*//如果是,则卸载
3) 下载Oracle JDK
4) 安装和配置
sudo mkdir /usr/local/java
sudo tar -zxf jdk.tar.gz(压缩包所在路径) -C /usr/local/java/
/usr/local/java/jdk(具体jdk版本)/bin/java -version
//配置环境变量
sudo vim /etc/profile
//添加以下内容
JAVA_HOME=/usr/local/java/jdk1.8.0_181
JRE_HOME=$JAVA_HOME/jre
CLASSPATH=.:$JAVA_HOME/lib:$JRE_HOME/lib
PATH=$JAVA_HOME/bin:$PATH
export JAVA_HOME
export JRE_HOME
export CLASSPATH
export PATH
//刷新立即生效
sudo -s
source /etc/profile
//验证
java -version/javac -version
2.安装vim
sudo apt-get remove vim-common
sudo apt-get install vim
3.安装idea
1) 官网下载压缩包without jdk
2) 解压缩
sudo tar -zxvf ideaIU.tar.gz(压缩包所在路径) -C /opt
3) 开启应用
cd /opt/idea-IU-版本号/bin/
sh idea.sh
4.创建快捷方式
cd /usr/share/applications
sudo touch idea.desktop
//在idea.desktop文件中添加以下内容
[Desktop Entry]
Name=IntelliJ IDEA
Comment=IntelliJ IDEA
Exec=env JAVA_HOME=/usr/local/java/jdk-版本号 /opt/idea-IU-版本号/bin/idea.sh
Icon=/opt/idea-IU-版本号/bin/idea.png
Terminal=false
Type=Application
Categories=Developer;
//改变文件权限可执行
-rwxr--r--
5.修改文件权限
Linux下的文件权限分为三种:r(读),w(写),x(执行)
用chmod修改用户权限
chmod的语法:
chmod [-可选参数][<权限范围>+/-/=<权限设置>] 文件/目录
1)指定某类用户的权限
chmod [ u / g / o / a ] [ + / - / = ] [ r / w / x ] file
--[ u / g / o / a ] 为权限范围，其中 
u：User，即文件或目录的拥有者 
g：Group，即文件或目录的所属群组 
o：Other，除了文件或目录拥有者和所属群组外，其他用户都属于这个范围 
a：All，即全部用户
--权限操作 
+表示增加权限 
-表示取消权限 
=表示取消之前的权限，并给予唯一的权限
--权限代号 
r：读取权限，数字代号为 “4” 
w：写入权限，数字代号为 “2” 
x：执行权限，数字代号为 “1” 
-：不具备任何权限，数字代号为 “0”
--file,文件名（路径）
例如:
sudo chmod u+rw /code/readme.txt//给 User 用户增加了对”/code/readme.txt”文件 “w” 和 “x” 的权限
2)同时指定三类用户的权限
chmod [xyz] file//其中x，y，z分别指定User、Group、Other的权限；用三位二进制数表示 ” r , w , x”（注意顺序）三种权限，其中 0 代表没有该权限，1 代表有该权限，如 100 则表示，有 ‘r”权限，无 “w x”权限；再将这个三位的二进制数转为十进制，则是 x (或y，z)的值
例如:
sudo chmod 774 /code/readme.txt
//User : 7 = 111 表示具有 ” r , w , x” 权限 
//Group : 7 = 111 表示具有 ” r , w , x” 权限 
//Other : 4 = 100 表示只具有 ” r ” 权限，而没有 “w,x” 权限
sudo chmod 774 *          //” * ” 为通配符，表示对当前所在目录下的所有文件做权限修改操作
sudo chmod -R 774 /code/  //修改这个目录，以及子目录下文件的权限
可选参数列表:
-c //当发生改变时报告处理信息
-f //错误信息不输出
-R //处理指定目录及子目录下的所有文件
-v //运行时显示详细处理信息
6.破解idea
1)sudo gedit /etc/hosts//打卡配置文件
//添加以下内容
0.0.0.0 account.jetbrains.com
2)打开网站http://idea.lanyus.com/,获取注册码,添加即可
```



