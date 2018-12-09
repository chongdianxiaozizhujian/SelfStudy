package com.yonyou.mapper;

import com.yonyou.bean.Employee;

/**
 * Created by Administrator on 2018/6/27.
 */
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);

}
