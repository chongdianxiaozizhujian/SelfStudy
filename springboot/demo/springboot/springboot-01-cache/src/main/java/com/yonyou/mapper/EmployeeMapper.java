package com.yonyou.mapper;

import com.yonyou.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * Created by Administrator on 2018/6/30.
 */
@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) values (#{lastName},#{email},#{gender},#{dId})")
    public Employee insertEmp(Employee employee);

    @Delete("delete from employee where id = #{id}")
    public int deleteEmp(Integer id);

    @Update("update employee set lastName = #{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id = #{id}")
    public int updateEmp(Employee employee);

    @Select("select * from employee where lastName = #{lastName}")
    public Employee getEmpByLastName(String lastName);
}
