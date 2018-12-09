package com.yonyou.config;

import com.yonyou.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/6/4.
 * 当前类为配置类,替代Spring的配置文件
 */
@Configuration
public class MyAppConfig {
    //方法的返回值添加到容器中
    //容器中此组件的默认id为方法名
    @Bean
    public HelloService helloService() {
        System.out.println("配置类");
        return new HelloService();
    }

}

