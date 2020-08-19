package com.yichen.springaop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        AopServer bean2 = (AopServer)ac.getBean("aopServer");
        String hello = bean2.getHello();
    }
}
