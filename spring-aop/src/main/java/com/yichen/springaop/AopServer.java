package com.yichen.springaop;

import org.springframework.stereotype.Service;

@Service
public class AopServer {
    String name="chenyi";
    public String getHello() {
        return "hello";
    }
}
