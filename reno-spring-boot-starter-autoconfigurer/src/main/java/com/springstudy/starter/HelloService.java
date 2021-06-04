package com.springstudy.starter;

/**
 * @author zbsilent
 * @date 2021年06月05日 12:13 上午
 */
public class HelloService {

    private HelloProperties helloProperties;

    public String sayHelloReno(String name){

        return helloProperties.getPrefix()+"-"+ name + helloProperties.getSuffix();
    }

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }
}
