package com.yonyou;

import com.yonyou.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02AmqpApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	@Test
	public void createExchange() {

		//amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
		//amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
		amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqpadmin.haha",null));
		System.out.println("创建完成");
	}

	@Test
	public void contextLoads() {
		//rabbitTemplate.send(exchange, routingKey, message);
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "这是第一个消息");
		map.put("data", Arrays.asList("hello amqp",123,true));
		rabbitTemplate.convertAndSend("exchange.direct", "yonyou.news", new Book("西游记","吴承恩"));
	}

	@Test
	public void receive() {
		Object o = rabbitTemplate.receiveAndConvert("yonyou.news");
		System.out.println(o.getClass());
		System.out.println(o);
	}

	@Test
	public void sendMsg() {
		rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("三国演义", "罗贯中"));
	}
}
