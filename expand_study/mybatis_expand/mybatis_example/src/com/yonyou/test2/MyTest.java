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
		int insert = session.insert(statement, new User(-1, "Ð¡Ö¾", 13));
		session.commit();
		session.close();
		System.out.println(insert);
	}
	
	@Test
	public void updateUser() {
		SqlSession session = Utils.getSession();
		String statement = "com.yonyou.test2.userMapper.updateUser";
		int update = session.update(statement, new User(4, "Ð¡Ææ", 15));
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
