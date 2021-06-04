package com.srpingsut.quick;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyAppConfig {
    /** 将方法返回值添加到容器中 id就是方法名*/
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
