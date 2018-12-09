package com.yonyou.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/7/3.
 */

@Configuration
public class MyAMQPConfig {

    @Bean
    public org.springframework.amqp.support.converter.MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
