package com.chilicool;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemoApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void contextLoads() {
		// 保存字符串
		System.out.println(stringRedisTemplate.opsForValue().get("serial_id"));
		stringRedisTemplate.opsForValue().increment("serial_id", 1);
		//stringRedisTemplate.opsForValue().set("aaa", "111");
		System.out.println(stringRedisTemplate.opsForValue().get("serial_id"));
		//Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("serial_id"));

	}

}
