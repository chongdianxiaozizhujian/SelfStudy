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
