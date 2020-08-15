package com.yichen.springautoresourceallocation.config;

import com.yichen.springautoresourceallocation.compent.YiChenBeanDefinitionRegistrar;
import com.yichen.springautoresourceallocation.compent.YiChenImportSelect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {YiChenImportSelect.class, YiChenBeanDefinitionRegistrar.class})
public class YiChenConfig {


    public YiChenAspect  yiChenAspect(){
        return new YiChenAspect();
    }

    @Conditional(value = YiChenConditionalz.class)
    @Bean
    public YiChenLog yiChenLog(){
        return new YiChenLog();
    }
}
