##### Linux环境安装postman

```java
1.下载
2.解压
--sudo tar -xzf Postman-linux-版本号.tar.gz /opt
--./Postman/Postman
注意:
error while loading shared libraries libgconf-2.so.4 cannot open shared object file 错误，则输入命令 $sudo apt install libgconf2-4 即可。
3.创建启动图标
1)建立软链接
sudo ln -s  /opt/Postman/Postman   /usr/bin/postman  (前面地址为安装目录，后面软链接地址)
2)创建启动项文件
--cd  /usr/share/applications
--sudo touch postman.desktop
--sudo vim postman.desktop
#写入以下内容
[Desktop Entry]
Encoding=UTF-8
Name=postman
Exec=postman
Icon=/opt/Postman/app/resources/app/assets/icon.png
Terminal=false
Type=Application
Categories=Development;
```

```java
1./boot空间不足解决办法
现象:gzip:stdout:No space left on device E:mkinitramfs failure find 141 cpio 141 gzip 1
1)查看系统已经安装的内核版本
dpkg --get-selections | grep linux-image
2)查看系统当前使用的内核版本
uname -a
3)删除旧的内核版本
--install 说明:系统已经安装了相应的内核,使用purge命令删除相应的内核
sudo apt purge linux-image-版本号-generic
--deinstall 说明:系统没有安装此内核,但是配置文件残留有它的信息,可能是之前卸载的不够彻底
4)查看效果
dpkg --get-selections | grep linux-image
df
```

