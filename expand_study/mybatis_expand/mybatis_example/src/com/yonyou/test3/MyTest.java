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
		int add = userMapper.add(new User(-1, "Ð¡Ö¾", 13));
		session.commit();
		session.close();
		System.out.println(add);
	}
	
	@Test
	public void updateUser() {
		SqlSession session = Utils.getSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		int update = userMapper.update(new User(5, "Ð¡Ææ", 15));
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
