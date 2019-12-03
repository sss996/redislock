package com.chen.redislock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RedislockApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedislockApplication.class, args);
    }

}
