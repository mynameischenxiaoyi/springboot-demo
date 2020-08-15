package com.yichen.springautoresourceallocation.controller;

import com.yichen.springautoresourceallocation.compent.YiChenCarServerImp;
import com.yichen.springautoresourceallocation.compent.YiChenServerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PageController {

    @Autowired
    YiChenServerImp yiChenServerImp;

    @Autowired
    YiChenCarServerImp yiChenCarServerImp;

    @RequestMapping(value = "/hello")
    public String welcome(){
        return yiChenServerImp.sayHello();
    }

    @RequestMapping(value = "/getcar")
    public String getcar(){
        return yiChenCarServerImp.bayCar();
    }




}
