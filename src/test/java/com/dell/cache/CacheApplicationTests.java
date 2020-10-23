package com.dell.cache;

import com.dell.cache.bean.Employee;
import com.dell.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class CacheApplicationTests {
    @Autowired
    EmployeeMapper em;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object, Employee> redisTemplate2;//使用自定义的json序列化
    @Test
    void contextLoads() {
        stringRedisTemplate.opsForValue().append("msg","somethingnew");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        Employee employeeById = em.getEmployeeById(1);
        redisTemplate2.opsForValue().set("EmpId1",employeeById);
    }
}
