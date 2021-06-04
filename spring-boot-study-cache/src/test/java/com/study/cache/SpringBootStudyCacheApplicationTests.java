package com.study.cache;

import com.study.cache.mapper.UserMapper;
import com.study.cache.pojo.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SpringBootStudyCacheApplicationTests {

    @Autowired
    UserMapper userMapper;
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
        userMapper.insertUser(userEntity);
    }


}
