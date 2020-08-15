package com.yichen.springmaven;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestMavenConterller {


    @Test
    public void testHello(){
        MavenConterller mavenConterller=new MavenConterller();
        String hello = mavenConterller.hello();
        System.out.println(hello);
    }
}
