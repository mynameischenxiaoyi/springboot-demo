package com.yichen.springaop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAopApplicationTests {

    @Autowired
    AopServer aopServer;

    @Test
    void contextLoads() {
        String hello = aopServer.getHello();
        System.out.println(hello);
    }

}
