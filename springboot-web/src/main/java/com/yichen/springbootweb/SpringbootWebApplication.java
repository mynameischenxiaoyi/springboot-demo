package com.yichen.springbootweb;

import com.yichen.springbootweb.bean.YichenPerson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableConfigurationProperties(YichenPerson.class)
@EnableTransactionManagement
public class SpringbootWebApplication  {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebApplication.class, args);
    }



}
