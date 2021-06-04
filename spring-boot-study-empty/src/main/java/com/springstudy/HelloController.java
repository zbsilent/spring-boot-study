package com.springstudy;

import com.springstudy.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbsilent
 * @date 2021年06月05日 12:35 上午
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;



    @GetMapping("/hello")
    public String getHelloService() {
        return  helloService.sayHelloReno("lli");
    }
}
