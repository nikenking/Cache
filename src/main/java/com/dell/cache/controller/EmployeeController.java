package com.dell.cache.controller;

import com.dell.cache.bean.Employee;
import com.dell.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService es;

    @GetMapping(value = {"/emp/{id}"})
    public String getEmployee(@PathVariable("id") Integer id){
        return es.getEmployeeById(id).toString();
    }

    @GetMapping(value = {"/emp"})
    public String upDataEmployee(Employee employee){
        return es.updataEmployee(employee).toString();
    }

    @GetMapping(value = {"/addEmp"})
    public String insertEmployee(Employee employee){
        System.out.println("添加的employee:"+employee.toString());
        es.insertEmployee(employee);
        return employee.toString();
    }

    @GetMapping(value = {"/delEmp"})
    public String delEmployee(Integer id){
        es.delEmployee(id);
        return "删除Id为"+id+"的用户";
    }

}
