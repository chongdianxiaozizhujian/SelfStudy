package com.yonyou.controller;

import com.yonyou.bean.Employee;
import com.yonyou.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/6/30.
 */

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id) {
        Employee employee = employeeService.getEmpById(id);
        return employee;
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee) {
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }

    @GetMapping("/delemp")
    public String delEmp(Integer id) {
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastname/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName) {
        return employeeService.getEmpByLastName(lastName);
    }
}
