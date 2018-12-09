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
}
