package com.yichen.springbootweb.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
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

//    @Bean(name = "dataSource",initMethod = "init")
//    @ConfigurationProperties(prefix = "spring.datasource.druid")
//    public DruidDataSource dateSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        return dataSource;
//    }
//
//     @Bean(name = "springbootMysqlJDBC")
//    public JdbcTemplate springbootMysqlJDBC(DruidDataSource druidDataSource){
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(druidDataSource);
//        return jdbcTemplate;
//    }






}
