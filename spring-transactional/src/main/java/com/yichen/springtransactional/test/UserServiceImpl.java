package com.yichen.springtransactional.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserServiceDao userServiceDao;

    @Override
    public Integer create(User user) {
        return userServiceDao.create(user);
    }

    @Override
    public void deleteByName(String userName) {

    }

    @Override
    public Integer getAllUsers() {
        return null;
    }

    @Override
    public void deleteAllUsers() {

    }

    @Override
    public void clearAdd(User user) {

    }
}
