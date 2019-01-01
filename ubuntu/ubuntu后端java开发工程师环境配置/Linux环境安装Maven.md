##### Linux环境安装Maven

```java
1.下载Maven
官网下载apache-maven-3.3.9-bin.tar.gz
2.解压缩
sudo tar -zxvf apache-maven-3.3.9-bin.tar.gz(压缩包具体路径) -C /opt
3.修改配置文件
sudo vim /etc/profile
添加以下内容
M2_HOME=/opt/apache-maven-3.3.9
CLASSPATH=之前的:$M2_HOME/lib
PATH=之前的:$M2_HOME/bin
export M2_HOME
4.刷新立即生效
source /etc/profile
5.查看版本
mvn -version
```

