package com.srpingsut.quick;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Reno
 */
//@ResponseBody
//@Controller
@RestController
public class HelloContorller {

    @RequestMapping("/hello")
    public String hello(){
        return "hello quick start";
    }

}
