package com.yichen.springbootweb;

import com.yichen.springbootweb.bean.YichenPerson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(YichenPerson.class)
public class SpringbootWebApplication  {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebApplication.class, args);
    }



}
