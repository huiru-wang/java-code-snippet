package com.xiaohan.demo.spring.redis.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;

/**
 * 本地缓存管理器，可以搭配注解管理缓存
 */
@Configuration
@EnableCaching
public class RedisCacheManagerConfig {

    @Bean
    public RedisCacheManager redisCacheManager(RedisTemplate<String, Object> redisTemplate) {
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getDefaultSerializer()));
        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
    }
}
