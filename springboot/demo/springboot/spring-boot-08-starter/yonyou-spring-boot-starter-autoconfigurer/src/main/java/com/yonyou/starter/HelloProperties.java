package com.yonyou.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Administrator on 2018/6/29.
 */

@ConfigurationProperties(prefix = "yonyou.hello")
public class HelloProperties {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
