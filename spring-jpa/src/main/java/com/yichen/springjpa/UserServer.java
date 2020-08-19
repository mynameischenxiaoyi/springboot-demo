package com.yichen.springjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserServer {

    @Autowired
    UsersDao usersDao;

    @Autowired
    UserParentDao userParentDao;

    public  List<Users> getUserList() {
        List<Users> all = usersDao.findAll();
        return  all;

    }

    public Users addUser(Users users) {
        Users save = usersDao.save(users);
        return save;
    }

    @Transactional
    public UserParent addUserParent(UserParent users) {
        UserParent save = userParentDao.save(users);
        int i=1/0;
        return save;
    }


    public  List<Map<String, Object>> findUserHaveParent(UserParent u) {
        return usersDao.findUserHaveParent(u.getUserid());
    }


    public  List<Map<String, Object>> findUserHaveParent(UserParent u,String a) {
        StringBuilder sql=new StringBuilder("select * from t_user_parent");

        return usersDao.findUserHaveParent(u.getUserid());
    }

}
