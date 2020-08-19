package com.yichen.springbootweb.controller;

import com.yichen.springbootweb.bean.Person;
import com.yichen.springbootweb.bean.YichenPerson;
import com.yichen.springbootweb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PageController {

    @Autowired
    YichenPerson yichenPerson;

    @RequestMapping(value = "/hello")
    public String welcome(){
        return yichenPerson.toString();
    }

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Person> getPersonList() {
        return personService.getPersonList();
    }


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insert(
            @RequestParam("name") String name,
            @RequestParam("age") String age
            ) {
        personService.insert(name,age);
    }
}
