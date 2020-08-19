package com.yichen.springtransactional.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Integer insert() {
        User user=new User();
        user.setUserId(1);
        user.setUserName("chenyi");
        user.setPassword("123456");
        user.setPhone("123456");
        Integer integer = userService.create(user);
        return integer;
    }


}
