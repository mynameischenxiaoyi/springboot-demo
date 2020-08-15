package com.yichen.springaop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
public class MyAop {

    @Pointcut("execution(* com.yichen.springaop.AopServer.*(..))")
    public void pintCut(){}

    @Before("com.yichen.springaop.MyAop.pintCut()")
    public void before(){
        System.out.println("执行前置通知");
    }

    @After("com.yichen.springaop.MyAop.pintCut()")
    public void after(){
        System.out.println("执行后置通知");
    }


}
