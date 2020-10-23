package com.dell.cache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCachePrefix;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {
//    @Bean
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer<Object> ser = new Jackson2JsonRedisSerializer<Object>(Object.class);
//        template.setDefaultSerializer(ser);
//        return template;
//    }

//    @Bean
//    public RedisCacheManager ObjectCacheManager( RedisTemplate<Object, Object> redisTemplate){
//        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        cacheManager.setUsePrefix(true);
//        return cacheManager;
//    }

//    @Bean
//    public RedisCacheManager ObjectCacheManager(RedisConnectionFactory redisConnectionFactory) {
//        //使用缓存的默认配置
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
//        //使用GenericJackson2JsonRedisSerializerz作为序列化器
//        config = config.serializeValuesWith(
//                RedisSerializationContext.SerializationPair.fromSerializer(
//                        new GenericJackson2JsonRedisSerializer()));
//        RedisCacheManager.RedisCacheManagerBuilder builder =
//                RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(config);
//        return builder.build();
//    }
}
