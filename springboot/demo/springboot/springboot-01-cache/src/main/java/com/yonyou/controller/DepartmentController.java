package com.yonyou.controller;

import com.yonyou.bean.Department;
import com.yonyou.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/1.
 */

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getDeptId(@PathVariable("id") Integer id) {
        Department department = departmentService.getDeptById(id);
        return department;
    }
}
