package com.xiaohan.demo.spring.redis.templateops;

import com.xiaohan.demo.spring.redis.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Random;
import java.util.Set;

@Slf4j
@SpringBootTest
public class ZsetOpsTest {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private ZSetOperations<String, String> zsetOperations;

    @Test
    public void testZsetOpsHello() {
        String key = RedisUtils.buildKey("hello", "zset");
        Boolean delete = redisTemplate.delete(key);
        log.info("key:{}, delete:{}", key, delete);

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            String value = "hello-" + i;
            int score = random.nextInt(10000);
            Boolean result = zsetOperations.add(key, value, score);
            Assert.isTrue(null != result && result, "Add Fail");
            log.info("key:{}, value:{}, score:{}", key, value, score);
        }

        Long size = zsetOperations.size(key);
        Assert.isTrue(null != size && 5 == size, "Add Fail");
        Set<String> members = zsetOperations.range(key, 0, 5);
        Assert.notNull(members, "Range Fail");

        ZSetOperations.TypedTuple<String> min = zsetOperations.popMin(key);
        Assert.notNull(min, "Pop Min Fail");
        String minValue = min.getValue();
        Double minScore = min.getScore();
        System.out.println("========== Min Score Member ==========");
        log.info("ZsetOps: [value:{}, score:{}]", minValue, minScore);
    }
}
