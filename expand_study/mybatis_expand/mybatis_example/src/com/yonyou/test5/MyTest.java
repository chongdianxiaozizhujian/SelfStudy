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
