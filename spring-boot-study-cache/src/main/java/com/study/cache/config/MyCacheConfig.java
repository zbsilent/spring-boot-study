package com.study.cache.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;

import java.lang.reflect.Method;
import java.util.Collections;


/**
 * @author zbsilent
 * @date 2021年06月05日 2:48 上午
 */
@Configuration
public class MyCacheConfig {


    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {

            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName() + "[" + Collections.singletonList(params).toString() + "]";
            }
        };
    }

}
