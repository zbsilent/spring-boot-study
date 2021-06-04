package com.springstudy.jpa.controller;

import com.springstudy.jpa.entity.User;
import com.springstudy.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author zbsilent
 * @date 2021年06月04日 9:16 下午
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userRepository.findByUserId(id);
    }

    @GetMapping("/user/userCode/{userCode}")
    public User findeUserByCode(@PathVariable("userCode") String userCode){
        return userRepository.findByUserCode(userCode);
    }

    @GetMapping("/user")
    public User addUser(User user){
       return userRepository.save(user);
    }
}
