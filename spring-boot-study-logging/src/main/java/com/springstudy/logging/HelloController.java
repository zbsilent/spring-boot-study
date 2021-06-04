package com.springstudy.logging;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zbsilent
 * @date 2021年06月03日 1:59 下午
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public  String helloLogging(){
        return "jeck";

    }
}
