package com.yonyou;

import com.yonyou.bean.Employee;
import com.yonyou.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	StringRedisTemplate stringRedisTemplate;//k-v操作字符串

	@Autowired
	RedisTemplate redisTemplate;//k-v对象

	@Autowired
	RedisTemplate<Object, Employee> empRedisTemplate;

	@Test
	public void contextLoads() {
		Employee employee = employeeMapper.getEmpById(1);
		System.out.println(employee);
	}

	@Test
	public void test01() {
		//stringRedisTemplate.opsForValue().append("msg", "hello");
		//String msg = stringRedisTemplate.opsForValue().get("msg");
		//System.out.println(msg);
		//stringRedisTemplate.opsForList().leftPush("mylist", "1");
		//stringRedisTemplate.opsForList().leftPush("mylist", "2");
		//Employee employee = employeeMapper.getEmpById(1);
		//redisTemplate.opsForValue().set("emp-01", employee);
		Employee employee = employeeMapper.getEmpById(2);
		empRedisTemplate.opsForValue().set("emp-02", employee);
	}
}
