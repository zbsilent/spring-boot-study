package com.springstudy.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import static java.lang.System.err;

/**
 * @author zbsilent
 * @date 2021年06月04日 11:24 下午
 */
public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {

    public HelloSpringApplicationRunListener(SpringApplication application, String[] args) {

    }

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        err.println("SpringApplicationRunListener....starting");
     }


    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        err.println("SpringApplicationRunListener....environmentPrepared");

    }



    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        err.println("SpringApplicationRunListener...contextPrepared...");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        err.println("SpringApplicationRunListener...contextLoaded...");

    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        err.println("SpringApplicationRunListener...started...");

    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        err.println("SpringApplicationRunListener...running...");

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        err.println("SpringApplicationRunListener...failed...");
    }
}
