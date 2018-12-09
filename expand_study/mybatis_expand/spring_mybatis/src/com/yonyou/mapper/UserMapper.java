package com.yonyou.mapper;

import java.util.List;

import com.yonyou.bean.SUser;

public interface UserMapper {
	void save(SUser user);
	void update(SUser user);
	void delete(int id);
	SUser findById(int id);
	List<SUser> findAll();
}
