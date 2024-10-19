package com.xiaohan.demo.spring.redis.templateops;

import com.xiaohan.demo.spring.redis.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.util.AssertionErrors;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class StringOpsTest {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private ValueOperations<String, String> valueOperations;

    @Test
    public void testStringOpsHello() {
        String key = RedisUtils.buildKey("hello", "string");
        Boolean delete = redisTemplate.delete(key);
        log.info("key:{}, delete:{}", key, delete);

        String value = "hello";
        valueOperations.set(key, value);

        String result = valueOperations.get(key);
        AssertionErrors.assertEquals("ValueOps Fail", value, result);
        log.info("StringOps: [key:{}, value:{}]", key, result);
    }

}
