package com.yichen.springbootredis.redisLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class RedisLock implements  DistributedLock {

    @Autowired
    RedisTemplate stringRedisTemplate;

    String lockScript="if redis.call('setnx',KEYS[1],ARGV[1]) == 1 then  return redis.call('expire',KEYS[1],ARGV[2])  else return 0 end";



    @Override
    public boolean lock(String requestId, String key, int expiresTime) {
        DefaultRedisScript<Long> longDefaultRedisScript = new DefaultRedisScript<>(lockScript, Long.class);
        Long result = (Long) stringRedisTemplate.execute(longDefaultRedisScript, Collections.singletonList(key), requestId,String.valueOf(expiresTime));
        return result == 1;
    }

    String unlockScript="if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";

    @Override
    public boolean releaseLock(String key, String requestId) {
        DefaultRedisScript<Long> longDefaultRedisScript = new DefaultRedisScript<>(unlockScript, Long.class);
        Long result = (Long) stringRedisTemplate.execute(longDefaultRedisScript, Collections.singletonList(key), requestId);
        return result == 1;
    }
}
