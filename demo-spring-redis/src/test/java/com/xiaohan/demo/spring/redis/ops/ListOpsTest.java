package com.xiaohan.demo.spring.redis.ops;

import com.xiaohan.demo.spring.redis.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Slf4j
@SpringBootTest
public class ListOpsTest {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private ListOperations<String, String> listOperations;

    @Test
    public void testListOpsHello() {
        String key = RedisUtils.buildKey("hello", "list");
        Boolean delete = redisTemplate.delete(key);
        log.info("key:{}, delete:{}", key, delete);

        String value = "hello-";
        for (int i = 0; i < 5; i++) {
            listOperations.rightPush(key, value + i);
        }

        List<String> result = listOperations.range(key, 0, 5);
        Assert.notNull(result, "ListOps Fail");
        for (int i = 0; i < 5; i++) {
            String item = result.get(i);
            Assert.isTrue(Objects.equals(item, value + i), "ListOps Fail");
            log.info("ListOps: [value:{}]", item);
        }
    }
}
