package com.travel.web;

import com.travel.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = AirCraftApplication.class)
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;

    @Test
    public void testRedis(){
        stringRedisTemplate.opsForValue().set("123","123");
    }

    @Test
    public void testGetUser(){
        userService.getUser(1);

        System.out.println("=========================");

        userService.getUser(1);
    }
}
