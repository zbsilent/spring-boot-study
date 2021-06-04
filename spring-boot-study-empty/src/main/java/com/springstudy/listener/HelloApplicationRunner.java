package com.springstudy.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static java.lang.System.err;

/**
 * @author zbsilent
 * @date 2021年06月04日 11:29 下午
 */
@Component
public class HelloApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        err.println("ApplicationRunner...run...");
    }
}
