package com.yonyou.service;

import com.yonyou.bean.Department;
import com.yonyou.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/1.
 */

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Qualifier("deptRedisCacheManager")
    @Autowired
    RedisCacheManager deptRedisCacheManager;

//    @Cacheable(cacheNames = "dept", cacheManager = "deptRedisCacheManager")
//    public Department getDeptById(Integer id) {
//        Department dept = departmentMapper.getDeptById(id);
//        return dept;
//    }

    public Department getDeptById(Integer id) {
        Department dept = departmentMapper.getDeptById(id);
        Cache cache = deptRedisCacheManager.getCache("dept");
        cache.put("1", dept);
        return dept;
    }
}
