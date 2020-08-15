package com.yichen.springmaven;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MavenConterller {

    @RequestMapping(value = "hello")
    public String hello(){
        return "hello everyone";
    }

    public static void main(String[] args) {
       
    }

}
