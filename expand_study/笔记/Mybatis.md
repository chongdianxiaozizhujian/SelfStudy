# MyBatis

## 一、MyBatis介绍

### 1.是什么

MyBatis是持久层框架，支持普通SQL查询、存储过程、高级映射

### 2.能用来做什么

MyBatis可以使用简单的XML或注解用于配置和原始映射，将接口和Java的POJO(Plain Old Java Objects，普通Java对象)映射成数据库中的记录

### 3.为什么用它

MyBatis消除了几乎所有的JDBC代码和参数的手工配置以及实现了对结果集的检索封装

JDBC->dbutils(自动封装)->MyBatis->Hibernate(完全面向对象)

MyBatis相对于JDBC和dbutils更加简单，相对于Hibernate更加灵活

## 二、MyBatis入门(怎么用)

### 1.创建工程mybatis_example

引入相关jar包:mybatis-3.1.1.jar，mysql-connector-java-5.1.7-bin.jar

建库建表

```mysql
create database mybatis;
use mybatis;
CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20), age INT);
INSERT INTO users(NAME, age) VALUES('小明', 12);
INSERT INTO users(NAME, age) VALUES('小华', 11);

```

### 2.添加MyBatis的配置文件conf.xml

直接在src目录下新建conf.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
	<environments default="development">
		<environment id="development">
			<transactionManager type="JDBC" />
			<dataSource type="POOLED">
				<property name="driver" value="com.mysql.jdbc.Driver" />
				<property name="url" value="jdbc:mysql://localhost:3306/mybatis" />
				<property name="username" value="root" />
				<property name="password" value="root" />
			</dataSource>
		</environment>
	</environments>
	<!--<mappers>
		<mapper resource="com/yonyou/test1/userMapper.xml" />
	</mappers>-->
</configuration>
```

### 3.创建POJO类User.java(定义表对应的实体类)

```java
package com.yonyou.bean;

public class User {
	private int id;
	private String name;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User() {
		super();
	}
	public User(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
```

### 4.定义操作users表的sql映射文件userMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace相对于此mapper的唯一标识 -->
<mapper namespace="com.yonyou.test1.userMapper">
	<select id="getUserById" parameterType="int" resultType="com.yonyou.bean.User">
		select * from users where id = #{id}
	</select>
</mapper>
```

### 5.将userMapper.xml文件注册到conf.xml文件中

```xml
	<mappers>
		<mapper resource="com/yonyou/test1/userMapper.xml" />
	</mappers>
```

### 6.编写案例Test.java

```java
package com.yonyou.test1;

import java.io.IOException;
import java.io.InputStream;
//import java.io.Reader;

//import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yonyou.bean.User;

public class Test {
	public static void main(String[] args) throws IOException {
		String resource = "conf.xml";
		//加载mybatis的配置文件（它也加载关联的映射文件）
		//Reader reader = Resources.getResourceAsReader(resource);
		//SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		//通过类加载器加载mybatis配置文件
		InputStream inputStream = Test.class.getClassLoader().getResourceAsStream(resource);
		//构建sqlSession工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//创建能执行映射文件中sql的sqlSession
		SqlSession session = factory.openSession();
		//映射sql的标识字符串
		String statement = "com.yonyou.test1.userMapper.getUserById";
		//查询条件
		int parameter = 1;
		//执行查询返回一个唯一User对象的sql
		User user = session.selectOne(statement, parameter);
		System.out.println(user);
	}
}
```

## 三、MyBatis的CRUD(怎么用)

新建工具类Utils.java

```java
package com.yonyou.utils;
import java.io.InputStream;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class Utils {
	public static SqlSession getSession() {
		String resource = "conf.xml";
		InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		return session;
	}
}
```



### 1.XML实现

定义sql映射xml文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace相对于此mapper的唯一标识 -->
<mapper namespace="com.yonyou.test2.userMapper">
	<select id="getUserById" parameterType="int" resultType="com.yonyou.bean.User">
		select * from users where id = #{id}
	</select>
	<insert id="addUser" parameterType="com.yonyou.bean.User">
		insert into users(name,age) values (#{name},#{age})
	</insert>
	<update id="updateUser" parameterType="com.yonyou.bean.User">
		update users set name = #{name}, age = #{age} where id = #{id}
	</update>
	<delete id="deleteUser" parameterType="int">
		delete from users where id = #{id}
	</delete>
	<select id="getAllUser" resultType="com.yonyou.bean.User">
		select * from users
	</select>
</mapper>
```

注册到conf.xml文件中

```xml
<mapper resource="com/yonyou/test2/userMapper.xml" />
```

CRUD案例

```java
package com.yonyou.test2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yonyou.bean.User;
import com.yonyou.utils.Utils;

public class MyTest {

	@Test
	public void addUser() {
		SqlSession session = Utils.getSession();
		String statement = "com.yonyou.test2.userMapper.addUser";
		int insert = session.insert(statement, new User(-1, "小志", 13));
		session.commit();
		session.close();
		System.out.println(insert);
	}
	
	@Test
	public void updateUser() {
		SqlSession session = Utils.getSession();
		String statement = "com.yonyou.test2.userMapper.updateUser";
		int update = session.update(statement, new User(4, "小奇", 15));
		session.commit();
		session.close();
		System.out.println(update);
	}
	
	@Test
	public void deleteUser() {
		SqlSession session = Utils.getSession();
		String statement = "com.yonyou.test2.userMapper.deleteUser";
		int delete = session.delete(statement, 4);
		session.commit();
		session.close();
		System.out.println(delete);
	}
	
	@Test
	public void getAllUser() {
		SqlSession session = Utils.getSession();
		String statement = "com.yonyou.test2.userMapper.getAllUser";
		List<User> list = session.selectList(statement);
		session.commit();
		session.close();
		System.out.println(list);
	}
}

```



### 2.注解实现

定义sql映射接口

```java
package com.yonyou.test3;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yonyou.bean.User;

public interface UserMapper {
	
	@Select("select * from users where id = #{id}")
	public int getById(int id);
	
	@Insert("insert into users(name,age) values (#{name},#{age})")
	public int add(User user);
	
	@Update("update users set name = #{name}, age = #{age} where id = #{id}")
	public int update(User user);
	
	@Delete("delete from users where id = #{id}")
	public int delete(int id);
	
	@Select("select * from users")
	public List<User> getList();
}

```

注册到conf.xml文件中

```xml
<mapper class="com.yonyou.test3.UserMapper" />
```

CRUD案例

```java
package com.yonyou.test3;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yonyou.bean.User;
import com.yonyou.utils.Utils;

public class MyTest {

	@Test
	public void addUser() {
		SqlSession session = Utils.getSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		int add = userMapper.add(new User(-1, "小志", 13));
		session.commit();
		session.close();
		System.out.println(add);
	}
	
	@Test
	public void updateUser() {
		SqlSession session = Utils.getSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		int update = userMapper.update(new User(5, "小奇", 15));
		session.commit();
		session.close();
		System.out.println(update);
	}
	
	@Test
	public void deleteUser() {
		SqlSession session = Utils.getSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		int delete = userMapper.delete(5);
		session.commit();
		session.close();
		System.out.println(delete);
	}
	
	@Test
	public void getAllUser() {
		SqlSession session = Utils.getSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> list = userMapper.getList();
		session.commit();
		session.close();
		System.out.println(list);
	}
}
```

## 四、优化(怎么用)

### 1.连接数据库的配置单独放在db.properties文件中

```properties
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/mybatis
username=root
password=root
```

conf.xml文件中需要添加或修改的内容

```xml
<!-- 新增 -->
<properties resource="db.properties" />
<!-- 修改 -->
<property name="driver" value="${driver}" />
<property name="url" value="${url}" />
<property name="username" value="${username}" />
<property name="password" value="${password}" />
```



### 2.为实体类定义别名，方便sql映射xml文件中引用

conf.xml文件中新增以下内容

```xml
<typeAliases>
    <!-- 单独起别名 -->
    <!-- <typeAlias type="com.yonyou.bean.User" alias="_User"/> -->
    <package name="com.yonyou.bean" />
</typeAliases>
```

### 3.加入log4j配置文件，方便打印日志

在src目录下新增log4j.xml或者log4j.propertes文件

log4j.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
	<appender name="STDOUT" class="org.apache.log4j.ConsoleAppender">
		<layout class="org.apache.log4j.PatternLayout">
			<param name="ConversionPattern" 
				value="%-5p %d{MM-dd HH:mm:ss,SSS} %m  (%F:%L) \n" />
		</layout>
	</appender>
	<logger name="java.sql">
		<level value="debug" />
	</logger>
	<logger name="org.apache.ibatis">
		<level value="debug" />
	</logger>
	<root>
		<level value="debug" />
		<appender-ref ref="STDOUT" />
	</root>
</log4j:configuration>
```

log4j.properties

```properties
log4j.rootLogger=DEBUG, Console
#Console
log4j.appender.Console=org.apache.log4j.ConsoleAppender
log4j.appender.Console.layout=org.apache.log4j.PatternLayout
log4j.appender.Console.layout.ConversionPattern=%d [%t] %-5p [%c] - %m%n
log4j.logger.java.sql.ResultSet=INFO
log4j.logger.org.apache=INFO
log4j.logger.java.sql.Connection=DEBUG
log4j.logger.java.sql.Statement=DEBUG
log4j.logger.java.sql.PreparedStatement=DEBUG

```

## 五、解决字段名和实体类属性名不相同的冲突(怎么用)

### 1.创建表、准备数据

```mysql
CREATE TABLE orders(
	order_id INT PRIMARY KEY AUTO_INCREMENT,
	order_no VARCHAR(20), 
	order_price FLOAT
);
INSERT INTO orders(order_no, order_price) VALUES('黄豆', 23);
INSERT INTO orders(order_no, order_price) VALUES('大米', 33);
INSERT INTO orders(order_no, order_price) VALUES('玉米', 22);
```

### 2.定义实体类

Order.java

```java
package com.yonyou.bean;

public class Order {
	private int id;
	private String orderNo;
	private float price;
	public Order() {
		super();
	}
	public Order(int id, String orderNo, float price) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNo=" + orderNo + ", price=" + price + "]";
	}
	
}

```

### 3.创建sql映射xml文件orderMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace相对于此mapper的唯一标识 -->
<mapper namespace="com.yonyou.test5.orderMapper">
    <!-- 字段名和实体类属性名不相同
                  字段名:
          order_id
          order_no
          order_price
                 属性名:
          id
	      orderNo
	      price
     -->
	<select id="getOrder" parameterType="int" resultType="Order">
		select * from orders where order_id = #{id}
	</select>
	<!-- sql语句中定义别名 -->
	<select id="getOrder1" parameterType="int" resultType="Order">
		select order_id id, order_no orderNo, order_price price from orders where order_id = #{id}
	</select>
	<!-- resultMap -->
	<select id="getOrder2" parameterType="int" resultMap="getOrder2Map">
		select * from orders where order_id = #{id}
	</select>
	<resultMap type="Order" id="getOrder2Map">
		<id property="id" column="order_id"/>
		<result property="orderNo" column="order_no"/>
		<result property="price" column="order_price"/>
	</resultMap>
</mapper>
```

### 4.在conf.xml注册

```xml
<mapper resource="com/yonyou/test5/orderMapper.xml" />
```

### 5.案例

```java
package com.yonyou.test5;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yonyou.bean.Order;
import com.yonyou.utils.Utils;

public class MyTest {
	
	@Test
	public void getOrder() {
		SqlSession session = Utils.getSession();
		String statement = "com.yonyou.test5.orderMapper.getOrder";
		statement = "com.yonyou.test5.orderMapper.getOrder1";
		statement = "com.yonyou.test5.orderMapper.getOrder2";
		Order order = session.selectOne(statement, 2);
		session.close();
		System.out.println(order);
	}
}

```

## 六、实现关联表查询(怎么用)

### 1.一对一关联

#### 1.创建表、准备数据

```mysql
CREATE TABLE teacher(
	t_id INT PRIMARY KEY AUTO_INCREMENT, 
	t_name VARCHAR(20)
);
CREATE TABLE class(
	c_id INT PRIMARY KEY AUTO_INCREMENT, 
	c_name VARCHAR(20), 
	teacher_id INT
);
ALTER TABLE class ADD CONSTRAINT fk_teacher_id FOREIGN KEY (teacher_id) REFERENCES teacher(t_id);	
INSERT INTO teacher(t_name) VALUES('LS1');
INSERT INTO teacher(t_name) VALUES('LS2');
INSERT INTO class(c_name, teacher_id) VALUES('bj_a', 1);
INSERT INTO class(c_name, teacher_id) VALUES('bj_b', 2);

```

#### 2.定义实体类

Classes.java

```java
package com.yonyou.bean;

public class Classes {

	private int id;
	private String name;
	private Teacher teacher;
	public Classes(int id, String name, Teacher teacher) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
	}
	public Classes() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + ", teacher=" + teacher + "]";
	}
	
}

```

Teacher.java

```java
package com.yonyou.bean;

public class Teacher {

	private int id;
	private String name;
	public Teacher() {
		super();
	}
	public Teacher(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + "]";
	}
	
}

```

#### 3.创建sql映射文件classMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace相对于此mapper的唯一标识 -->
<mapper namespace="com.yonyou.test6.classMapper">
    <!-- 
    	嵌套结果:
    	使用嵌套结果映射来①处理重复的联合结果的子集(去除重复数据)②封装联表查询的数据
    	select * from class c, teacher t where c.teacher_id = t.t_id and c.c_id = 1
     -->
     <select id="getClass" parameterType="int" resultMap="getClassMap">
     	select * from class c, teacher t where c.teacher_id = t.t_id and c.c_id = #{id}
     </select>
     <resultMap type="Classes" id="getClassMap">
     	<id property="id" column="c_id"/>
     	<result property="name" column="c_name"/>
     	<association property="teacher" javaType="Teacher">
     		<id property="id" column="t_id"/>
     		<result property="name" column="t_name"/>
     	</association>
     </resultMap>
     <!-- 
     	select * from class where c_id = 1;
		select * from teacher where t_id = 1;
      -->
      <select id="getClass2" parameterType="int" resultMap="getClass2Map">
      	select * from class where c_id = #{id}
      </select>
      <resultMap type="Classes" id="getClass2Map">
      	<id property="id" column="c_id"/>
      	<result property="name" column="c_name"/>
      	<association property="teacher" column="teacher_id" select="getTeacher">
      	</association>
      </resultMap>
      <select id="getTeacher" parameterType="int" resultType="Teacher">
      	select t_id id, t_name name from teacher where t_id = #{id} 
      </select>
</mapper>
```

#### 4.在conf.xml注册

```xml
<mapper resource="com/yonyou/test6/classMapper.xml" />
```

#### 5.案例

```java
package com.yonyou.test6;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yonyou.bean.Classes;
import com.yonyou.utils.Utils;

public class MyTest {
	
	@Test
	public void getClasses() {
		SqlSession session = Utils.getSession();
		String statement = "com.yonyou.test6.classMapper.getClass";
		statement = "com.yonyou.test6.classMapper.getClass2";
		Classes classes = session.selectOne(statement, 2);
		session.close();
		System.out.println(classes);
	}
}

```

#### 6.重点

association:用于一对一关联查询

property:对象属性名称

javaType:对象属性类型

column:对应外键字段名称

select:使用另一个查询封装的结果

### 2.一对多关联

#### 1.创建表、准备数据

```mysql
CREATE TABLE student(
	s_id INT PRIMARY KEY AUTO_INCREMENT, 
	s_name VARCHAR(20), 
	class_id INT
);
INSERT INTO student(s_name, class_id) VALUES('xs_A', 1);
INSERT INTO student(s_name, class_id) VALUES('xs_B', 1);
INSERT INTO student(s_name, class_id) VALUES('xs_C', 1);
INSERT INTO student(s_name, class_id) VALUES('xs_D', 2);
INSERT INTO student(s_name, class_id) VALUES('xs_E', 2);
INSERT INTO student(s_name, class_id) VALUES('xs_F', 2);

```

#### 2.定义实体类

Student.java

```java
package com.yonyou.bean;

public class Student {
	private int id;
	private String name;
	public Student() {
		super();
	}
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}

```

Classes.java新增字段

```java
private List<Student> list;
```

#### 3.创建sql映射xml文件classMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace相对于此mapper的唯一标识 -->
<mapper namespace="com.yonyou.test7.classMapper">
    <!-- 
    	嵌套结果:
    	使用嵌套结果映射来①处理重复的联合结果的子集(去除重复数据)②封装联表查询的数据
    	select * from class c, teacher t, student s WHERE c.teacher_id = t.t_id and c.c_id = s.class_id and c.c_id = 1
     -->
     <select id="getClass" parameterType="int" resultMap="getClassMap">
     	select * from class c, teacher t, student s WHERE c.teacher_id = t.t_id and c.c_id = s.class_id and c.c_id = #{id}
     </select>
     <resultMap type="Classes" id="getClassMap">
     	<id property="id" column="c_id"/>
     	<result property="name" column="c_name"/>
     	<association property="teacher" column="teacher_id" javaType="Teacher">
     		<id property="id" column="t_id"/>
     		<result property="name" column="t_name"/>
     	</association>
     	<collection property="list" column="c_id" ofType="Student">
     		<id property="id" column="s_id"/>
     		<result property="name" column="s_name"/>
     	</collection>
     </resultMap>
     <!-- 
     	嵌套查询:
     	通过执行另外一个sql映射语句返回预期的复杂类型
     	SELECT * from class where c_id = 1;
		SELECT * from teacher where t_id = 1;
		SELECT * from student where class_id = 1;
      -->
      <select id="getClass2" parameterType="int" resultMap="getClass2Map">
      	SELECT * from class where c_id = #{id}
      </select>
      <resultMap type="Classes" id="getClass2Map">
      	<id property="id" column="c_id"/>
      	<result property="name" column="c_name"/>
      	<association property="teacher" column="teacher_id" select="getTeacher">
      	</association>
      	<collection property="list" column="c_id" select="getStudent">
      	</collection>
      </resultMap>
      <select id="getTeacher" parameterType="int" resultType="Teacher">
      	select t_id id, t_name name from teacher where t_id = #{id}
      </select>
      <select id="getStudent" parameterType="int" resultType="Student">
      	select s_id id, s_name name from student where class_id = #{id}
      </select>
</mapper>
```

#### 4.在conf.xml注册

```xml
<mapper resource="com/yonyou/test7/classMapper.xml" />
```

#### 5.案例

```java
package com.yonyou.test7;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yonyou.bean.Classes;
import com.yonyou.utils.Utils;

public class MyTest {
	
	@Test
	public void getClasses() {
		SqlSession session = Utils.getSession();
		String statement = "com.yonyou.test7.classMapper.getClass";
		statement = "com.yonyou.test7.classMapper.getClass2";
		Classes classes = session.selectOne(statement, 2);
		session.close();
		System.out.println(classes);
	}
}

```

#### 6.重点

collection:一对多关联查询

ofType:指定集合中元素对象的类型

## 七、动态SQL与模糊查询(怎么用)

### 1.创建表、准备数据

```mysql
create table d_user(  
	id int primary key auto_increment,  
	name varchar(10),
	age int(3)
); 

insert into d_user(name,age) values('Tom',12);  
insert into d_user(name,age) values('Bob',13);  
insert into d_user(name,age) values('Jack',18);

```

### 2.定义实体类

User.java

ConditionUser.java

```java
package com.yonyou.bean;

public class ConditionUser {
	private String name;
	private int minAge;
	private int maxAge;
	public ConditionUser() {
		super();
	}
	public ConditionUser(String name, int minAge, int maxAge) {
		super();
		this.name = name;
		this.minAge = minAge;
		this.maxAge = maxAge;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	@Override
	public String toString() {
		return "ConditionUser [name=" + name + ", minAge=" + minAge + ", maxAge=" + maxAge + "]";
	}
	
}

```

### 3.创建sql映射xml文件userMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace相对于此mapper的唯一标识 -->
<mapper namespace="com.yonyou.test8.classMapper">
    <select id="getUser" parameterType="ConditionUser" resultType="User">
    	select * from d_user where 
    	<if test="name != null">
    		name like CONCAT('%',#{name},'%') and 
    	</if>
    	age between #{minAge} and #{maxAge}
    </select>
</mapper>
```

### 4.在conf.xml注册

```xml
<mapper resource="com/yonyou/test8/classMapper.xml" />
```

### 5.案例

```java
package com.yonyou.test8;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yonyou.bean.ConditionUser;
import com.yonyou.bean.User;
import com.yonyou.utils.Utils;

public class MyTest {
	
	@Test
	public void getUser() {
		SqlSession session = Utils.getSession();
		String statement = "com.yonyou.test8.classMapper.getUser";
		ConditionUser parameter = new ConditionUser();
		parameter.setName("b");
		parameter.setMinAge(13);
		parameter.setMaxAge(19);
		List<User> user = session.selectList(statement, parameter);
		session.close();
		System.out.println(user);
	}
}

```

### 6.重点

动态SQL元素和使用JSTL或其它相似的基于XML的文本处理器相似。在MyBatis之前的版本中，有很多的元素需要来了解。MyBatis 3 大大提升了它们，现在用不到原先一半 的元素就能工作了。MyBatis 采用功能强大的基于 OGNL的表达式来消除其他元素。 

 if,choose(when,otherwise),trim(where,set),foreach

## 八、使用存储过程(怎么用)

### 1.创建表、创建存储过程

```mysql
-- 创建表
create table p_user(  
	id int primary key auto_increment,  
	name varchar(10),
	sex char(2)
); 

insert into p_user(name,sex) values('A',"男");  
insert into p_user(name,sex) values('B',"女");  
insert into p_user(name,sex) values('C',"男"); 
-- 创建存储过程
delimiter $
create PROCEDURE mybatis.get_user_count(in sex_id INT, OUT user_count INT)
BEGIN
IF sex_id = 0 THEN
SELECT COUNT(*) FROM mybatis.p_user where p_user.sex='女' into user_count;
ELSE
SELECT COUNT(*) FROM mybatis.p_user where p_user.sex='男' into user_count;
END IF;
END
$
-- 调用存储过程
set @user_count=0;
CALL mybatis.get_user_count(0, @user_count);
SELECT @user_count;
```

2.定义实体类

```java
package com.yonyou.bean;

public class PUser {
	private String id;
	private String name;
	private String sex;
	public PUser() {
		super();
	}
	public PUser(String id, String name, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "PUser [id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}
	
}

```

### 3.创建sql映射xml文件userMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace相对于此mapper的唯一标识 -->
<mapper namespace="com.yonyou.test9.userMapper">
    <!-- 
    	CALL mybatis.get_user_count(0, @user_count);
     -->
     <select id="getUserCount" parameterMap="getUserCountMap" statementType="CALLABLE">
     	CALL mybatis.get_user_count(?, ?);
     </select>
     <parameterMap type="java.util.Map" id="getUserCountMap">
     	<parameter property="sexId" mode="IN" jdbcType="INTEGER"/>
     	<parameter property="userCount" mode="OUT" jdbcType="INTEGER"/>
     </parameterMap>
</mapper>
```

### 4.在conf.xml注册

```xml
<mapper resource="com/yonyou/test9/userMapper.xml" />
```

### 5.案例

```java
package com.yonyou.test9;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yonyou.utils.Utils;

public class MyTest {
	
	@Test
	public void getUser() {
		SqlSession session = Utils.getSession();
		String statement = "com.yonyou.test9.userMapper.getUserCount";
		Map<String, Integer> parameterMap = new HashMap<>();
		parameterMap.put("sexId", 0);
		parameterMap.put("userCount", -1);
		session.selectOne(statement, parameterMap);
		session.close();
		System.out.println(parameterMap.get("userCount"));
	}
}

```

### 6.重点

```xml
<select>
	parameterMap:引用<parameterMap>
	statementType:STATEMENT(非预编译)(默认)
    			 PREPARED(预编译)
    			 CALLABLE(执行调用存储过程的语句)
<parameterMap>
    type:需要传递的参数类型 java.util.Map
    <parameter>:指定传递的参数  key-value

```

## 九、MyBatis缓存(怎么用)

### 1.MyBatis缓存

MyBatis提供了一级缓存和二级缓存

一级缓存:作用域为session

二级缓存:作用域为mapper(namespace)，可自定义存储源，如ehcache

### 2.一级缓存

#### 1.创建表、准备数据

```mysql
CREATE TABLE c_user(
	id INT PRIMARY KEY AUTO_INCREMENT, 
	NAME VARCHAR(20), 
	age INT
);
INSERT INTO c_user(NAME, age) VALUES('Tom', 12);
INSERT INTO c_user(NAME, age) VALUES('Jack', 11);

```

#### 2.定义实体类

```java
package com.yonyou.bean;

import java.io.Serializable;

public class CUser implements Serializable{
	private int id;
	private String name;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public CUser() {
		super();
	}
	public CUser(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}

```

#### 3.创建sql映射xml文件userMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace相对于此mapper的唯一标识 -->
<mapper namespace="com.yonyou.test10.userMapper">
	<cache />
    <select id="getUser" parameterType="int" resultType="CUser">
		select * from c_user where id=#{id}
	</select>

	<update id="updateUser" parameterType="CUser">
		update c_user set
		name=#{name}, age=#{age} where id=#{id}
	</update>
    
</mapper>
```

#### 4.在conf.xml注册

```xml
<mapper resource="com/yonyou/test10/userMapper.xml" />
```

#### 5.案例

```java
package com.yonyou.test10;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.yonyou.bean.CUser;
import com.yonyou.utils.Utils;

public class MyTest {
	/*
	 * MyBatis一级缓存:默认开启
	 * 满足条件:①必须是同一个session
	 * 		 ②查询条件一样
	 *       ③没有close()或clearCache()
	 *       ④没有CUD(增、改、删操作)
	 */
	
	@Test
	public void getUser() {
		SqlSession session = Utils.getSession();
		String statement = "com.yonyou.test10.userMapper.getUser";
		/*默认开启缓存
		CUser cUser = session.selectOne(statement, 1);
		System.out.println(cUser);
		cUser = session.selectOne(statement, 1);
		System.out.println(cUser);*/
		/*①必须是同一个session
		SqlSession session1 = Utils.getSession();
		CUser cUser = session.selectOne(statement, 1);
		System.out.println(cUser);
		cUser = session1.selectOne(statement, 1);
		System.out.println(cUser);
		*/
		/*②查询条件一样
		CUser cUser = session.selectOne(statement, 1);
		System.out.println(cUser);
		cUser = session.selectOne(statement, 2);
		System.out.println(cUser);
		*/
		/*
		③没有close()或clearCache()
		CUser cUser = session.selectOne(statement, 1);
		System.out.println(cUser);
		session.clearCache();
		cUser = session.selectOne(statement, 1);
		System.out.println(cUser);
		*/
		/*
		 * ④没有CUD(增、改、删操作)
		CUser cUser = session.selectOne(statement, 1);
		System.out.println(cUser);
		String statement1 = "com.yonyou.test10.userMapper.updateUser";
		int update = session.update(statement1, new CUser(1, "小华", 20));
		//session.commit();
		System.out.println(update);
		cUser = session.selectOne(statement, 1);
		System.out.println(cUser);
		*/
	}
}

```

### 3.二级缓存

#### 1.在userMapper.xml文件中新增<cache />标签，开启二级缓存

#### 2.案例

在MyTest.java中新增案例代码

```java
/*@Test
	public void getUser2() {
	    //因为Utils.getSession()取得是同一个，所以没有起作用
		SqlSession session = Utils.getSession();
		String statement = "com.yonyou.test10.userMapper.getUser";
		CUser cUser = session.selectOne(statement, 1);
		System.out.println(cUser);
		session.commit();
		SqlSession session1 = Utils.getSession();
		cUser = session1.selectOne(statement, 1);
		System.out.println(cUser);
		session1.commit();
	}*/
	@Test
	public void getUser3() {
		String resource = "conf.xml";
		InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		String statement = "com.yonyou.test10.userMapper.getUser";
		CUser cUser = session.selectOne(statement, 1);
		System.out.println(cUser);
		session.commit();
		SqlSession session1 = factory.openSession();
		cUser = session1.selectOne(statement, 1);
		System.out.println(cUser);
	}
```

### 4.拓展(针对二级缓存)(重点)

```java
-- 映射语句文件中的所有 select 语句将会被缓存。
-- 映射语句文件中的所有 insert，update 和 delete 语句会刷新缓存。
-- 缓存会使用 Least Recently Used（LRU，最近最少使用的）算法来收回。
-- 根据时间表（比如 no Flush Interval，没有刷新间隔），缓存不会以任何时间顺序
来刷新。
-- 缓存会存储列表集合或对象（无论查询方法返回什么）的 1024 个引用。
-- 缓存会被视为是 read/write（可读/可写）的缓存，意味着对象检索不是共享的，而
且可以安全地被调用者修改，而不干扰其他调用者或线程所做的潜在修改。
所有的这些属性都可以通过缓存元素的属性来修改。比如：
<cache
eviction="FIFO"
flushInterval="60000"
size="512"
readOnly="true"/>
这个更高级的配置创建了一个 FIFO 缓存，并每隔 60 秒刷新，存数结果对象或列表的
512 个引用，而且返回的对象被认为是只读的，因此在不同线程中的调用者之间修改它们会
导致冲突。
可用的收回策略有：
-- LRU – 最近最少使用的：移除最长时间不被使用的对象。
-- FIFO – 先进先出：按对象进入缓存的顺序来移除它们。
-- SOFT – 软引用：移除基于垃圾回收器状态和软引用规则的对象。
-- WEAK – 弱引用：更积极地移除基于垃圾收集器状态和弱引用规则的对象。
默认的是 LRU。
flushInterval（刷新间隔）可以被设置为任意的正整数，而且它们代表一个合理的毫秒
形式的时间段。默认情况是不设置，也就是没有刷新间隔，缓存仅仅调用语句时刷新。
size（引用数目）可以被设置为任意正整数，要记住你缓存的对象数目和你运行环境的
可用内存资源数目。默认值是 1024。
readOnly（只读）属性可以被设置为 true 或 false。只读的缓存会给所有调用者返回缓
存对象的相同实例。因此这些对象不能被修改。这提供了很重要的性能优势。可读写的缓存
会返回缓存对象的拷贝（通过序列化）。这会慢一些，但是安全，因此默认是 false。
```

## 十、Spring集成MyBatis

### 1.创建工程spring_mybatis

添加jar包

```java
mybatis:
		mybatis-3.2.0.jar
		mybatis-spring-1.1.1.jar
		log4j-1.2.17.jar
sptring:
		spring-aop-3.2.0.RELEASE.jar
		spring-beans-3.2.0.RELEASE.jar
		spring-context-3.2.0.RELEASE.jar
		spring-core-3.2.0.RELEASE.jar
		spring-expression-3.2.0.RELEASE.jar
		spring-jdbc-3.2.0.RELEASE.jar
		spring-test-3.2.4.RELEASE.jar
		spring-tx-3.2.0.RELEASE.jar
      -- 依赖包
         aopalliance-1.0.jar
		cglib-nodep-2.2.3.jar
		commons-logging-1.1.1.jar
mysql驱动包
 		mysql-connector-java-5.0.4-bin.jar
```

### 2.创建表

```mysql
CREATE TABLE s_user(
	user_id INT AUTO_INCREMENT PRIMARY KEY,
	user_name VARCHAR(30),
	user_birthday DATE,
	user_salary DOUBLE
)

```

### 3.定义实体类

```java
package com.yonyou.bean;

import java.util.Date;

public class SUser {
	private int id;
	private String name;
	private Date birthday;
	private double salary;
	public SUser() {
		super();
	}
	public SUser(int id, String name, Date birthday, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "SUser [id=" + id + ", name=" + name + ", birthday=" + birthday + ", salary=" + salary + "]";
	}
	
}

```

### 4.定义接口

```java
package com.yonyou.mapper;

import java.util.List;

import com.yonyou.bean.SUser;

public interface UserMapper {
	void save(SUser user);
	void update(SUser user);
	void delete(int id);
	SUser findById(int id);
	List<SUser> findAll();
}

```

### 5.创建sql映射xml文件userMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.yonyou.mapper.UserMapper">
	<resultMap type="SUser" id="userResult">
		<result column="user_id" property="id"/>
		<result column="user_name" property="name"/>
		<result column="user_birthday" property="birthday"/>
		<result column="user_salary" property="salary"/>
	</resultMap>

	<!-- 取得插入数据后的id -->
	<insert id="save" keyColumn="user_id" keyProperty="id" useGeneratedKeys="true">
		insert into s_user(user_name,user_birthday,user_salary)
		values(#{name},#{birthday},#{salary})
	</insert>

	<update id="update">
		update s_user
		set user_name = #{name},
			user_birthday = #{birthday},
			user_salary = #{salary}
		where user_id = #{id}
	</update>
	
	<delete id="delete">
		delete from s_user
		where user_id = #{id}
	</delete>

	<select id="findById" resultMap="userResult">
		select *
		from s_user
		where user_id = #{id}
	</select>
	
	<select id="findAll" resultMap="userResult">
		select * 
		from s_user
	</select>
</mapper>

```

### 6.创建Spring配置文件beans.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p" 
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="
		http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
		http://www.springframework.org/schema/context
		http://www.springframework.org/schema/context/spring-context-3.2.xsd
		http://www.springframework.org/schema/tx
		http://www.springframework.org/schema/tx/spring-tx-3.2.xsd">
	<!-- 1. 数据源 : DriverManagerDataSource -->
	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<property name="url" value="jdbc:mysql://localhost:3306/mybatis" />
		<property name="username" value="root" />
		<property name="password" value="root" />
	</bean>
	
	<!-- 
		2. mybatis的SqlSession的工厂: SqlSessionFactoryBean 
			dataSource / typeAliasesPackage
	-->
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"/>
		<property name="typeAliasesPackage" value="com.yonyou.bean" />
	</bean>

	<!-- 
		3. mybatis自动扫描加载Sql映射文件 : MapperScannerConfigurer 
			sqlSessionFactory / basePackage
	-->
	<bean id="conf" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="sqlSessionFactory" ref="sqlSessionFactory" />
		<property name="basePackage" value="com.yonyou.mapper" />
	</bean>
	
	<!-- 4. 事务管理 : DataSourceTransactionManager -->
	<bean id="manager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource"/>
	</bean>

	<!-- 5. 使用声明式事务 -->
	<tx:annotation-driven transaction-manager="manager" />
</beans>

```

### 7.创建MyBatis配置文件mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
	<!-- Spring整合myBatis后，这个配置文件基本可以不要了-->
	<!-- 设置外部配置文件 -->
	<!-- 设置类别名 -->
	<!-- 设置数据库连接环境 -->
	<!-- 映射文件 -->	
</configuration>

```

### 8.案例

```java
package com.yonyou.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yonyou.bean.SUser;
import com.yonyou.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class MyTest {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void saveUser() {
		SUser sUser = new SUser();
		sUser.setBirthday(new Date());
		sUser.setName("小勇");
		sUser.setSalary(1000);
		userMapper.save(sUser);
	}
}

```

