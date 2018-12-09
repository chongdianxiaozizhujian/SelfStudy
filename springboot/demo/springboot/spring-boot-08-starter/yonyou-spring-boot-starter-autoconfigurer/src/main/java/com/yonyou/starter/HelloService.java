package com.yonyou.starter;

/**
 * Created by Administrator on 2018/6/29.
 */
public class HelloService {

    HelloProperties helloProperties;

    public String sayHelloYonyou(String name) {
        return helloProperties.getPrefix() + "-" + name + "-" + helloProperties.getSuffix();
    }

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }
}
