package com.springstudy.listener;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import static java.lang.System.err;
/**
 * @author zbsilent
 * @date 2021年06月04日 11:21 下午
 */
public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        err.println("ApplicationContextInitializer...Initialize ");
    }
}
