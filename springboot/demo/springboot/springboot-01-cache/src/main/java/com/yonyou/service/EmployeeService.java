package com.yonyou.service;

import com.yonyou.bean.Employee;
import com.yonyou.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/6/30.
 */
@CacheConfig(cacheNames = {"emp"})
@Service
public class EmployeeService {
    // , unless = "#result == null"
    // key = "#root.methodName+'['+ #id +']'"
    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = {"emp"}/*, condition = "#id>1", unless = "#a0==2", keyGenerator = "myKeyGenerator"*/)
    public Employee getEmpById(Integer id) {
        Employee employee = employeeMapper.getEmpById(id);
        System.out.println("查询"+ id + "号员工" + employee.getLastName());
        return employee;
    }

    @CachePut(cacheNames = {"emp"}, key = "#result.id")
    public Employee updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(cacheNames = {"emp"}, beforeInvocation = true/*, key = "#id", allEntries = true*/)
    public void deleteEmp(Integer id) {
        //employeeMapper.deleteEmp(id);
        System.out.println("删除员工" + id + "号");
        int i = 1/0;
    }

    @Caching(
            cacheable = {
                    @Cacheable(key = "#lastName")
            },
            put = {
                    @CachePut(key = "#result.id"),
                    @CachePut(key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName) {
        return employeeMapper.getEmpByLastName(lastName);
    }
}
