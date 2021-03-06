package com.yonyou.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yonyou.bean.SUser;
import com.yonyou.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class MyTest {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void saveUser() {
		SUser sUser = new SUser();
		sUser.setBirthday(new Date());
		sUser.setName("С��");
		sUser.setSalary(1000);
		userMapper.save(sUser);
	}
}
