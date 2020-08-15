package com.yichen.springjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserServer userServer;

    @RequestMapping("list")
    public List<Users> getList(){
        return userServer.getUserList();
    }

    @RequestMapping("add")
    public Users addUser(Users users){
        return userServer.addUser(users);
    }

    @RequestMapping("addUserParent")
    public UserParent addUserParent(UserParent users){
        return userServer.addUserParent(users);
    }

    @RequestMapping("findUserHaveParent")
    public List<Map<String,Object>> findUserHaveParent(UserParent u){
        return userServer.findUserHaveParent(u);
    }


    @GetMapping("/{id}")
    public void getUserInfo(@PathVariable("id") String userId) {
        System.out.println("hello");
    }

    @GetMapping("/list")
    public void pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        System.out.println("hello");
    }





}
