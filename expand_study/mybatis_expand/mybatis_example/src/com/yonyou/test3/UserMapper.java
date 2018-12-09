package com.yonyou.test3;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yonyou.bean.User;

public interface UserMapper {
	
	@Select("select * from users where id = #{id}")
	public int getById(int id);
	
	@Insert("insert into users(name,age) values (#{name},#{age})")
	public int add(User user);
	
	@Update("update users set name = #{name}, age = #{age} where id = #{id}")
	public int update(User user);
	
	@Delete("delete from users where id = #{id}")
	public int delete(int id);
	
	@Select("select * from users")
	public List<User> getList();
}
