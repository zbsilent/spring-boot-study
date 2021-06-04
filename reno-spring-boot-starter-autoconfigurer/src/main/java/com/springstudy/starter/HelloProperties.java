package com.springstudy.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zbsilent
 * @date 2021年06月05日 12:13 上午
 */
@ConfigurationProperties(prefix = "reno.hello")
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
