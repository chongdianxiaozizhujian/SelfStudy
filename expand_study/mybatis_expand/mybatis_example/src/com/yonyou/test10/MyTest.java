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
	 * MyBatisһ������:Ĭ�Ͽ���
	 * ��������:�ٱ�����ͬһ��session
	 * 		 �ڲ�ѯ����һ��
	 *       ��û��close()��clearCache()
	 *       ��û��CUD(�����ġ�ɾ����)
	 */
	
	@Test
	public void getUser() {
		SqlSession session = Utils.getSession();
		String statement = "com.yonyou.test10.userMapper.getUser";
		/*Ĭ�Ͽ�������
		CUser cUser = session.selectOne(statement, 1);
		System.out.println(cUser);
		cUser = session.selectOne(statement, 1);
		System.out.println(cUser);*/
		/*�ٱ�����ͬһ��session
		SqlSession session1 = Utils.getSession();
		CUser cUser = session.selectOne(statement, 1);
		System.out.println(cUser);
		cUser = session1.selectOne(statement, 1);
		System.out.println(cUser);
		*/
		/*�ڲ�ѯ����һ��
		CUser cUser = session.selectOne(statement, 1);
		System.out.println(cUser);
		cUser = session.selectOne(statement, 2);
		System.out.println(cUser);
		*/
		/*
		��û��close()��clearCache()
		CUser cUser = session.selectOne(statement, 1);
		System.out.println(cUser);
		session.clearCache();
		cUser = session.selectOne(statement, 1);
		System.out.println(cUser);
		*/
		/*
		 * ��û��CUD(�����ġ�ɾ����)
		CUser cUser = session.selectOne(statement, 1);
		System.out.println(cUser);
		String statement1 = "com.yonyou.test10.userMapper.updateUser";
		int update = session.update(statement1, new CUser(1, "С��", 20));
		//session.commit();
		System.out.println(update);
		cUser = session.selectOne(statement, 1);
		System.out.println(cUser);
		*/
	}
	
	/*@Test
	public void getUser2() {
	    //��ΪUtils.getSession()ȡ����ͬһ��������û��������
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