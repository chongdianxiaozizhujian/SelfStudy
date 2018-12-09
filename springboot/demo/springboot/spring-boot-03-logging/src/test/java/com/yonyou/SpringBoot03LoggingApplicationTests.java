package com.yonyou;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03LoggingApplicationTests {

	@Test
	public void contextLoads() {
//		Logger logger = LoggerFactory.getLogger(SpringBoot03LoggingApplicationTests.class);
		Logger logger = LoggerFactory.getLogger(getClass());
		//日志级别由低到高
		logger.trace("trace日志-----------");
		logger.debug("debug日志-----------");
		logger.info("info日志------------");
		logger.warn("warn日志------------");
		logger.error("error日志-----------");
	}

}
