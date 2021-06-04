package com.study.cache.controller;

import com.study.cache.pojo.UserEntity;
import com.study.cache.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zbsilent
 * @date 2021年06月05日 2:03 上午
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public UserEntity getUser(@PathVariable("id") int id ){
        return userService.getUser(id);
    }
    @PostMapping("/user")
    public UserEntity svaeUser(@RequestBody UserEntity userEntity){
        return userService
                .updateUser(userEntity);
    }

    @GetMapping("/userdel/{userid}")
    public void delete(@PathVariable("userid") int userid){
         userService.delEmp(userid);
    }

}
