package com.yichen.springbootredis;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
       if(bean instanceof RedisTemplate){
            RedisTemplate redisTemplate = (RedisTemplate) bean;
           redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
           return redisTemplate;
       }

        return bean;
    }


}
