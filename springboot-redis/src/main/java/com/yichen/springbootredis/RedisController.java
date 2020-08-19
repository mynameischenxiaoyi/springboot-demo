package com.yichen.springbootredis;

import com.yichen.springbootredis.redisLock.RedisLock;
import org.redisson.RedissonRedLock;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
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
    RedisTemplate redisTemplate;

    @Autowired
    RedisLock redisLock;

    @PostMapping(value = "/setString")
    public String setString(
            @RequestParam(value = "key") String key,
            @RequestParam(value = "value") String value
    ) {
        try {
            if(redisLock.lock("1L","123",500000)){
                redisTemplate.opsForValue().set(key, value);
            }else {
                return "false";
            }
        }finally {
            redisLock.releaseLock("123","1L");
        }
        return "success";
    }


    @Autowired
    RedissonClient redissonClient;

    @PostMapping(value = "/redissonClientTest")
    public String  redissonClientTest(
    @RequestParam(value = "key") String key,
    @RequestParam(value = "value") String value
    ) {
        RLock lock = redissonClient.getLock("1L");
        try {
            lock.lock();
            boolean f=true;
            while (f){
                Thread.sleep(1000);
            }
            redisTemplate.opsForValue().set(key, value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return "success";
    }

    @PostMapping("/setRedissonBlockingQueue")
    public Boolean setRedissonBlockingQueue( @RequestParam(value = "value") String key){
        RBlockingQueue<Object> blockingQueue = redissonClient.getBlockingQueue("2L");
         if(blockingQueue.add(key)){
             return true;
         }
         return false;
    }

    @PostMapping("/getRedissonBlockingQueue")
    public Object getRedissonBlockingQueue( @RequestParam(value = "key") String key){
        RBlockingQueue<Object> blockingQueue = redissonClient.getBlockingQueue("2L");
        return  blockingQueue.poll();
    }


    @PostMapping("/testRedissonRedLock")
    public Object testRedissonRedLock(){
        RLock l1 = redissonClient.getLock("1L");
        RedissonRedLock lock = new RedissonRedLock(l1);
        try {
            lock.lock();
            boolean f=true;
            while (f){
                Thread.sleep(1000);
            }
            redisTemplate.opsForValue().set("haha", "haha");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        };
        return "";
    }



}
