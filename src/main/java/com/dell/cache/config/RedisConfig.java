package com.dell.cache.config;

import com.dell.cache.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;
import org.springframework.http.codec.json.Jackson2JsonDecoder;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<Object, Employee> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> ser = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        template.setDefaultSerializer(ser);
        return template;
    }

//    @Bean
//    public RedisCacheManager employeeCacheManager(RedisConnectionFactory redisConnectionFactory) {
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
