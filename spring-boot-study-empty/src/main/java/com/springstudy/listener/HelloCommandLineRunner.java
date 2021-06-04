package com.springstudy.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static java.lang.System.err;

/**
 * @author zbsilent
 * @date 2021年06月04日 11:32 下午
 */
@Component
public class HelloCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        err.println("CommandLineRunner....run...");
    }
}
