package com.study.cache;

import com.study.cache.mapper.UserMapper;
import com.study.cache.pojo.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Date;

@SpringBootTest
class SpringBootStudyCacheApplicationTests {

    @Autowired
    UserMapper userMapper;

   // RedisAutoConfiguration


    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate  redisTemplate;

    @Autowired
    private RedisTemplate<Object, UserEntity> userRedisTemplate;
    @Test
    void contextLoads() {

        UserEntity userById = userMapper.getUserById(1);
        System.out.println(userById.getUserName());
    }
    @Test
    public void updateUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(1);
        userEntity.setUserCode("123123");
        userEntity.setUserName("liqiang");
        userEntity.setBirth(new Date());
        userMapper.updateUser(userEntity);
    }
    @Test
    public void saveUser(){
        UserEntity userEntity = new UserEntity();
//        userEntity.setUserId(1);
        userEntity.setUserCode("7788");
        userEntity.setUserName("chendu");
        userEntity.setBirth(new Date());
        userRedisTemplate.opsForValue().set("user-01",userEntity);
        //redisTemplate.opsForValue().set("dp-2",userEntity);
        //userMapper.insertUser(userEntity);
    }

    @Test
    public void addRedis(){
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        //stringStringValueOperations.set("phoneNum","18684015021");
        stringStringValueOperations.append("phoneNum","18983041");
    }


}
