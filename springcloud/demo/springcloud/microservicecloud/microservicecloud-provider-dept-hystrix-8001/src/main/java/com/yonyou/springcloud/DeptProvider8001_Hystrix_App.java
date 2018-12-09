package com.yonyou.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
//@EnableDiscoveryClient,可以不加,@EnableEurekaClient包含了
public class DeptProvider8001_Hystrix_App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DeptProvider8001_Hystrix_App.class, args);
	}
}
