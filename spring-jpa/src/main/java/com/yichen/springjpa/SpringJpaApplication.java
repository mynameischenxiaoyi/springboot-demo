package com.yichen.springjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class SpringJpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
    }
}
