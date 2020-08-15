package com.yichen.springaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {

    @Autowired
    AopServer aopServer;

    @RequestMapping("/hello")
    public String hello(){
       return aopServer.getHello();
    }
}
