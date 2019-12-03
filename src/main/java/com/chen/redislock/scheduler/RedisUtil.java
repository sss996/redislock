package com.chen.redislock.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 取得锁，
     * @param key String  设置key
     * @param value String 设置value
     * @param  expireTime 过期时间
     * */
    public boolean getLock(String key, String value, int expireTime){

        // 设置锁，设置前判断Key是否已存在，不存在则，设置key，value，
        // 然后返回true。
        // 如果锁已存在 则返回false，
        if(stringRedisTemplate.opsForValue().setIfAbsent(key,value)){
            // 设置Key过期时间，防止死锁
            stringRedisTemplate.expire(key,expireTime, TimeUnit.SECONDS);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 释放锁，如果锁不存在
     * */
    public void releaseLock(String key){
        stringRedisTemplate.delete(key);
    }

}
