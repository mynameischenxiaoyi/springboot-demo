package com.yichen.springautoresourceallocation.compent;

public class YiChenServerImp {
    public YiChenServerImp() {
        System.out.println("YiChenServerImp已经注入了");
    }
    public String sayHello(){
        return "hello";
    }
}
