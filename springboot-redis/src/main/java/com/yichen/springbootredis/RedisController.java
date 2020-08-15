package com.yichen.springbootredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

@RestController
public class RedisController {


    @Autowired
    ValueOperations valueOperations;

    @PostMapping(value = "/setString")
    public String setString(
            @RequestParam(value = "key") String key,
            @RequestParam(value = "value") String value
    ) {
        valueOperations.set(key, value);
        return "success";
    }
}
