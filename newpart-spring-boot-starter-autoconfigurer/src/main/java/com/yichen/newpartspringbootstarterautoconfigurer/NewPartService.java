package com.yichen.newpartspringbootstarterautoconfigurer;

public class NewPartService {
    NewPartProperties newPartProperties;
    public NewPartProperties getNewPartProperties() {
        return newPartProperties;
    }
    public void setNewPartProperties(NewPartProperties newPartProperties) {
        this.newPartProperties = newPartProperties;
    }
    public String sayName(String name){
        return newPartProperties.getFirstName()+name+newPartProperties.getLastName()+" age: " + newPartProperties.getAge();
    }
}
