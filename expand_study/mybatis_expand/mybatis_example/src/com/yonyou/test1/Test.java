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
		//����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
		//Reader reader = Resources.getResourceAsReader(resource);
		//SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		//ͨ�������������mybatis�����ļ�
		InputStream inputStream = Test.class.getClassLoader().getResourceAsStream(resource);
		//����sqlSession����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//������ִ��ӳ���ļ���sql��sqlSession
		SqlSession session = factory.openSession();
		//ӳ��sql�ı�ʶ�ַ���
		String statement = "com.yonyou.test1.userMapper.getUserById";
		//��ѯ����
		int parameter = 1;
		//ִ�в�ѯ����һ��ΨһUser�����sql
		User user = session.selectOne(statement, parameter);
		System.out.println(user);
	}
}
