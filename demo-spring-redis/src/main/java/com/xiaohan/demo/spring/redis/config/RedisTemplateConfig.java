package com.xiaohan.demo.spring.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * redis的客户端
 * <pre>
 * redisTemplate: Spring原生
 * redisson: 第三方
 * </pre>
 */
@Configuration
@EnableCaching
public class RedisTemplateConfig {

    @Resource
    private LettuceConnectionFactory lettuceConnectionFactory;

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        ObjectMapper objectMapper = createObjectMapper();

        // 设置key的序列化方式
        template.setKeySerializer(createStringRedisSerializer());
        // 设置value的序列化方式
        template.setValueSerializer(createJackson2JsonRedisSerializer(objectMapper));

        template.setHashKeySerializer(createStringRedisSerializer());
        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));

        // 设置连接池
        template.setConnectionFactory(lettuceConnectionFactory);
        return template;
    }

    private ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.activateDefaultTyping(
                objectMapper.getPolymorphicTypeValidator(),
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.PROPERTY
        );
        return objectMapper;
    }

    private Jackson2JsonRedisSerializer<Object> createJackson2JsonRedisSerializer(ObjectMapper objectMapper) {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        return jackson2JsonRedisSerializer;
    }

    private StringRedisSerializer createStringRedisSerializer() {
        return new StringRedisSerializer();
    }

    @Bean
    public HashOperations<String, String, Object> hashOperations(StringRedisTemplate stringRedisTemplate) {
        return stringRedisTemplate.opsForHash();
    }

    @Bean
    public ValueOperations<String, String> valueOperations(StringRedisTemplate stringRedisTemplate) {
        return stringRedisTemplate.opsForValue();
    }

    @Bean
    public ListOperations<String, String> listOperations(StringRedisTemplate stringRedisTemplate) {
        return stringRedisTemplate.opsForList();
    }

    @Bean
    public SetOperations<String, String> setOperations(StringRedisTemplate stringRedisTemplate) {
        return stringRedisTemplate.opsForSet();
    }

    @Bean
    public ZSetOperations<String, String> zSetOperations(StringRedisTemplate stringRedisTemplate) {
        return stringRedisTemplate.opsForZSet();
    }
}
