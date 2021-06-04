package com.srpingsut.quick;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringBootStudyQuickApplicationTests {

    @Autowired
    ApplicationContext ioc;

    @Test
    public void testHelloService(){
        boolean helloService = ioc.containsBean("helloService");
    }
    @Test
    void contextLoads() {
    }

}
