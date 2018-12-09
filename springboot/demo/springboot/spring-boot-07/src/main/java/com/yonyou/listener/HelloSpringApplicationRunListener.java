package com.yonyou.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Created by Administrator on 2018/6/28.
 */
public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {

    public HelloSpringApplicationRunListener(SpringApplication springApplication, String[] args) {

    }

    @Override
    public void starting() {
        System.out.println("HelloSpringApplicationRunListener ... starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment configurableEnvironment) {

        Object o = configurableEnvironment.getSystemProperties().get("os.name");
        System.out.println("HelloSpringApplicationRunListener ... environmentPrepared" + o);
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("HelloSpringApplicationRunListener ... contextLoaded" + configurableApplicationContext);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("HelloSpringApplicationRunListener ... contextPrepared" + configurableApplicationContext);
    }

    @Override
    public void started(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("HelloSpringApplicationRunListener ... started" + configurableApplicationContext);
    }

    @Override
    public void running(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("HelloSpringApplicationRunListener ... running" + configurableApplicationContext);
    }

    @Override
    public void failed(ConfigurableApplicationContext configurableApplicationContext, Throwable throwable) {
        System.out.println("HelloSpringApplicationRunListener ... failed" + configurableApplicationContext);
    }

}
