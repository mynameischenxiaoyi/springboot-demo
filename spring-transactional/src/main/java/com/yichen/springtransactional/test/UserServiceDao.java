package com.yichen.springtransactional.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserServiceDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public Integer create(User user) {
        int update = jdbcTemplate.update("insert into t_user(user_name, password, phone) values (?, ?, ?)",
                user.getUserName(), user.getPassword(), user.getPhone());
        int i=1/0;
        return update;
    }

    public void deleteByName(String userName) {
        jdbcTemplate.update("delete from T_USER where USER_Name = ?", userName);
    }

    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from T_USER", Integer.class);
    }

    public void deleteAllUsers() {
        jdbcTemplate.update("delete from t_user");
    }

    @Transactional
    public void clearAdd(User user) {
        this.deleteAllUsers();
        this.create(user);
    }
}
