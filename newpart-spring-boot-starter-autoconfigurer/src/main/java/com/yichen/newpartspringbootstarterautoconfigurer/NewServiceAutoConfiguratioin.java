package com.yichen.newpartspringbootstarterautoconfigurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(NewPartProperties.class)
public class NewServiceAutoConfiguratioin {

    @Autowired
    NewPartProperties newPartProperties;

    @Bean
    public NewPartService newPartService(){
        NewPartService partService = new NewPartService();
        partService.setNewPartProperties(newPartProperties);
        return partService;
    }
}
