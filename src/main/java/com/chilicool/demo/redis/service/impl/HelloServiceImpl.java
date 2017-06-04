package com.chilicool.demo.redis.service.impl;

import com.chilicool.demo.redis.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by zechenzhang on 2017/6/3.
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Long getHelloFraquncy() {
        stringRedisTemplate.opsForValue().increment("serial_id", 1L);
        Long currVal = Long.parseLong(stringRedisTemplate.opsForValue().get("serial_id"));
        return currVal;
    }
}
