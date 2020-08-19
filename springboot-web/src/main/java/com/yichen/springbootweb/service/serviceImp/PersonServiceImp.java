package com.yichen.springbootweb.service.serviceImp;

import com.yichen.springbootweb.bean.Person;
import com.yichen.springbootweb.dao.PersonDao;
import com.yichen.springbootweb.dao.PersonDaoImp;
import com.yichen.springbootweb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImp implements PersonService {

    @Autowired
    PersonDaoImp personDao;

    @Override
    public List<Person> getPersonList() {
        return personDao.getPersonList();
    }

    @Override
    @Transactional
    public void insert(String name, String age) {
        personDao.insert(name, age);
    }
}
