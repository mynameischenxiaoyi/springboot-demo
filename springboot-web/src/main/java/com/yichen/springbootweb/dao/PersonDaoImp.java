package com.yichen.springbootweb.dao;

import com.yichen.springbootweb.bean.Person;

import java.util.List;

public interface PersonDaoImp {
    void insert(String name, String age);

    List<Person> getPersonList();

}
