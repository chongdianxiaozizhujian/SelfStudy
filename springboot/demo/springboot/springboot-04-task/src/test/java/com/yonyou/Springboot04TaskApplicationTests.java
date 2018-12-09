package com.yonyou;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04TaskApplicationTests {

	@Autowired
	JavaMailSenderImpl mailSender;
	@Test
	public void contextLoads() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setSubject("通知-来自朱朱");
		simpleMailMessage.setText("你很优秀,加入我们");
		simpleMailMessage.setTo("18867312106@163.com");
		simpleMailMessage.setFrom("2943110083@qq.com");
		mailSender.send(simpleMailMessage);
	}

	@Test
	public void test02() throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.addAttachment("1.jpg", new File("E:\\1.jpg"));
		helper.addAttachment("2.jpg", new File("E:\\2.jpg"));
		helper.setSubject("通知-来自朱朱");
		helper.setText("<b style='color:red'>你非常优秀</b>", true);
		helper.setTo("18867312106@163.com");
		helper.setFrom("2943110083@qq.com");
		mailSender.send(mimeMessage);
	}

}
