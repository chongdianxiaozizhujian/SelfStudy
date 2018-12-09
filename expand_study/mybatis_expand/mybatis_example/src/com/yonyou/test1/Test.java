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
