package com.dell.cache.service;

import com.dell.cache.bean.Employee;
import com.dell.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "emp")//抽取公共配置，除了配置当前server的全局仓库，总共有四大功能，这是其一
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper em;

    /**
     * CacheManager管理多个Cache组件的，对缓存的真正的CURD的操作在Cache组件中，每一个缓存组件有自己唯一的名字
     * 一：指定缓存组件的名字：CacheNames,/value 指定缓存组件的名字；
     * key：缓存数据使用的key；
     * 方法一：key = "#id"//通过Spel表达式
     * 方式二：key = "#root.args[0]"//按位数取
     * condition = "#id>0"指定条件
     * unless当xx条件满足时就不缓存了,比指定条件厉害点，可以得到结果集
     * */

    @Cacheable(cacheNames = "emp",key = "#id")//将这个方法的运行结果进行缓存
    public Employee getEmployeeById(Integer id){
        Employee employee = em.getEmployeeById(id);
        System.out.println("未缓存，查询employee:"+employee.toString());
        return employee;
    }

    @Caching(
            cacheable = {
                    @Cacheable(value = "emp",key = "#lastname")
            },
            put = {//因为CachePut起作用了，所以方法还是会执行的，但返回结果是之前缓存的
                    @CachePut(value = "emp",key = "#result.id"),
                    @CachePut(value = "emp",key = "#result.email")
            }
    )
    public Employee getEmployeeBylastname(String lastname){
        return em.getEmployeeBylastname(lastname);
    }

    @CachePut(value = "emp",key = "#result.id")
    public Employee updataEmployee(Employee employee){
        System.out.println("需同时加入到emp缓存区的employee："+employee.toString());
        em.updataEmployee(employee);
        return employee;
    }

    public void insertEmployee(Employee employee){
        em.insertEmployee(employee);
    }

    @CacheEvict(value = "emp",key = "#id"/*,allEntries = true*//*一口气全部删除,在方法执行之前删除所有，优先级最高，谨慎使用,
    beforeInvocation = true//在方法之前就删除,*/)
    public void delEmployee(Integer id){
        System.out.println("删除的id:"+id);
        em.delEmployee(id);
    }

    @Cacheable(cacheNames = "emp",key = "#flag")//将这个方法的运行结果进行缓存
    public List<Employee> getEmployeeAll(String flag){
        List<Employee> employees = em.getEmployeeAll();
        System.out.println("未缓存，查询所有employee");
        return employees;
    }

}
