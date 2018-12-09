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
