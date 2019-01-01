##### Linux环境安装navicat

```java
1.下载
2.解压缩
sudo -zxvf navicat-版本号.tar.gz /opt
3.启动
./start_navicat
#需要安装wine mono和wine gecko
4.创建快捷方式
cd /usr/share/applications
sudo touch navicat.desktop
sudo vim navicat.desktop
#添加以下内容
[Desktop Entry]
Encoding=UTF-8
Name=Navicat
Comment=Navicat Premium
Exec=/opt/navicat版本号/start_navicat
Icon=/opt/navicat版本号/navicat.png
Terminal=false
StartupNotify=true
Type=Application
Categories=Application;Development;
5.解决界面乱码问题
1)打开start_navicat文件，会看到 export LANG="en_US.UTF-8" 将这句话改为 export LANG="zh_CN.UTF-8"
2)查看系统支持的字符集: locale -a
3)修改字符集: export LANG=zh_CN.utf8
4)打开navicat界面,选择菜单栏第五个(工具(T))-->选项(最后一个)-->常规-->界面字体选择Noto Sans mono CJK SC Regular-->(编辑器-->编辑器字体-->记录-->网格字体)保存，退出，重新打开，正常
```

