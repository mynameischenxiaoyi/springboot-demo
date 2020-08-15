package com.yichen.springbootweb.dao;

import com.yichen.springbootweb.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDao {

    @Autowired
    @Qualifier("springbootMysqlJDBC")
    JdbcTemplate jdbcTemplate;


    public List<Person> getPersonList() {
        List<Person> list = jdbcTemplate.query("select * from person", new Object[]{}, new BeanPropertyRowMapper(Person.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }

    }
}
