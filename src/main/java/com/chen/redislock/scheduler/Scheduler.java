package com.chen.redislock.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * 新建两个相同的定时任务，模拟多实例
 * */
@Component
public class Scheduler {

    @Autowired
    private RedisUtil util;

    @Scheduled(cron = "0/10 * * * * ?")
    public void getAllDate11(){
        if(util.getLock("getData","getting!",5)){
            System.out.println(" getAllDate  11  取得锁开始执行！！！！");
        }
    }

    @Scheduled(cron = "0/10 * * * * ?")
    public void getAllDate22(){
        if(util.getLock("getData","getting!",5)){
            System.out.println(" getAllDate  22  取得锁开始执行！！！！");
        }
    }

}
