package com.yonyou.springcloud.service;

import java.util.List;

import com.yonyou.springcloud.entities.Dept;

public interface DeptService
{
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
