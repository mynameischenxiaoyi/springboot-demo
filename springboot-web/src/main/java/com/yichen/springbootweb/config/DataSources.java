package com.yichen.springbootweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class DataSources {
    @Value(value = "${spring.datasource.driver-class-name}")
    private String mysqlDriver;

    @Value(value = "${spring.datasource.url}")
    private String url;

    @Value(value = "${spring.datasource.username}")
    private String username;

    @Value(value = "${spring.datasource.password}")
    private String password;

    @Bean(name = "springbootMysqlJDBC")
    public JdbcTemplate springbootMysqlJDBC(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(mysqlDriver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(ds);
        return jdbcTemplate;
    }


}
