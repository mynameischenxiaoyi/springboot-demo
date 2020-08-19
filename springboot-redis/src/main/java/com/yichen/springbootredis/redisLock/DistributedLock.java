package com.yichen.springbootredis.redisLock;

public interface DistributedLock {
    /**
     * 获取锁
     * @param requestId 请求id uuid
     * @param key 锁key
     * @param expiresTime 失效时间 ms
     * @return 获取锁成功 true
     */
    boolean lock(String requestId,String key,int expiresTime);

    /**
     * 释放锁
     * @param key 锁key
     * @param requestId 请求id uuid
     * @return 成功释放 true
     */
    boolean releaseLock(String key,String requestId);
}
