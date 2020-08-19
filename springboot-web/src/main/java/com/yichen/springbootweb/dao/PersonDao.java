package com.yichen.springbootweb.dao;

import com.yichen.springbootweb.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Repository
public class PersonDao implements PersonDaoImp {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void insert(String name, String age) {
        String sql = "INSERT INTO person VALUE (1,'chenyi',23)";
        jdbcTemplate.update(sql);
        int i = 1 / 0;
        String sql1 = "INSERT INTO `user` VALUE (1,'chenyi',23,'332336308')";
        jdbcTemplate.update(sql1);
    }

    @Override
    public List<Person> getPersonList() {
        return null;
    }

   /* @Autowired
    public void insert(String name, String age) {
        String sql = "INSERT INTO person VALUE (1,'chenyi',23)";
        //String sql = "update person set age=24 where  id=1";
        jdbcTemplate.update(sql);
        int i = 1 / 0;
        String sql1 = "INSERT INTO `user` VALUE (1,'chenyi',23,'332336308')";
        jdbcTemplate.update(sql1);
    }

    @Override
    public List<Person> getPersonList() {
        List<Person> list = jdbcTemplate.query("select * from person", new Object[]{}, new BeanPropertyRowMapper(Person.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }

    }*/


}
