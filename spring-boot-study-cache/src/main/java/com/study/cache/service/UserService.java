package com.study.cache.service;

import com.study.cache.mapper.UserMapper;
import com.study.cache.pojo.UserEntity;
import org.apache.ibatis.logging.log4j2.Log4j2LoggerImpl;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author zbsilent
 * @date 2021年06月05日 1:54 上午
 */
@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;



    @Cacheable(cacheNames={"user"},condition = "#id>0" ,key = "#id")
    public UserEntity getUser(int id){
        logger.debug("查询员工"+id+"，的信息");
        return userMapper.getUserById(id);
    }


    @CachePut(cacheNames={"user"},key = "#result.userId")
    public UserEntity updateUser(UserEntity entity){
        logger.debug("更新员工"+entity.getUserName()+"，的信息");
        userMapper.updateUser(entity);
        return  entity;
    }

    @CacheEvict(cacheNames={"user"},/*key = "#userId"*/allEntries = true,beforeInvocation = true)
    public void delEmp(int userId){
        logger.debug("删除员工"+userId+"，的信息");
        userMapper.deleteUserByid(userId);
    }
}
