package com.dell.cache;

import com.dell.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CacheApplicationTests {
    @Autowired
    EmployeeMapper em;
    @Test
    void contextLoads() {
        System.out.println(em.getEmployeeById(1));
    }

}
