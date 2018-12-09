package com.yonyou.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient,可以不加,@EnableEurekaClient包含了
public class DeptProvider8002_App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DeptProvider8002_App.class, args);
	}
}
