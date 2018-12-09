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
		String statement = "com.yonyou.test8.userMapper.getUser";
		ConditionUser parameter = new ConditionUser();
		parameter.setName("b");
		parameter.setMinAge(13);
		parameter.setMaxAge(19);
		List<User> user = session.selectList(statement, parameter);
		session.close();
		System.out.println(user);
	}
}
