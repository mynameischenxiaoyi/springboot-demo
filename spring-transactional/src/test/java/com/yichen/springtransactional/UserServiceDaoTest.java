package com.yichen.springtransactional;

import com.yichen.springtransactional.test.UserServiceDao;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceDaoTest {

    @Resource
    private UserServiceDao userService;

    @Before
    public void setUp() {
        // 准备，清空user表
        userService.deleteAllUsers();
    }


}
