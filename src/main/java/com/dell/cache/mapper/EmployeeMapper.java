package com.dell.cache.mapper;

import com.dell.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id = #{id}")
    public Employee getEmployeeById(Integer id);
    @Update("UPDATE employee set lastName=#{lastName},email=#{email},gender=#{gender},dId=#{dId} where id = #{id}")
    public void updataEmployee(Employee employee);
    @Delete("delete from employee where id=#{id}")
    public void delEmployee(Integer id);
    @Insert("insert into employee(lastName,email,gender,dId) values(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmployee(Employee employee);
    @Select("select * from employee where lastName = #{lastName}")
    public Employee getEmployeeBylastname(String lastName);
    @Select("Select * from employee")
    public List<Employee> getEmployeeAll();
}