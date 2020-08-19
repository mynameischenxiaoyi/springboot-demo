package com.yichen.springaop;

import org.springframework.stereotype.Service;

@Service
public class AopServer {
    String name="chenyi";
    public String getHello() {
        System.out.println("执行hello方法");
        return "hello";
    }
}
