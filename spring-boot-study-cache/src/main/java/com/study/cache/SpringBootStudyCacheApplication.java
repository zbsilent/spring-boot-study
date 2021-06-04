package com.study.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 
 * @author zbsilent
 * @date 2021/6/5 1:54 上午
 * @description       
 */
@SpringBootApplication
@MapperScan("com.study.cache.mapper")
@EnableCaching
public class SpringBootStudyCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStudyCacheApplication.class, args);
    }

}
