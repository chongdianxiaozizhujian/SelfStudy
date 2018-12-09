package com.yonyou.suggest.dao;

import java.util.ArrayList;
import java.util.List;

import com.yonyou.suggest.bean.Company;

public class CompanyDao {
	
	public static final List<Company> COMPANY = new ArrayList<>();
	
	static {
		COMPANY.add(new Company(11, "Ajax学习指南"));
		COMPANY.add(new Company(12, "在Web项目中使用Ajax"));
		COMPANY.add(new Company(13, "Ajax异步交互"));
		COMPANY.add(new Company(14, "透析Ajax对象"));
		COMPANY.add(new Company(15, "详解Ajax异步交互技术"));
		COMPANY.add(new Company(16, "jQuery技术内幕"));
		COMPANY.add(new Company(17, "深度理解jQuery框架结构"));
		COMPANY.add(new Company(18, "jQuery中的JavaScript精华"));
	}
	
	public static List<Company> queryList(String queryStr) {
		queryStr = queryStr.toLowerCase();
		List<Company> companyList = new ArrayList<>();
		
		for (Company company : COMPANY) {
			String companyName = company.getCompanyName().toLowerCase();
			boolean contains = companyName.contains(queryStr);
			if(contains) {
				companyList.add(company);
			}
		}
		
		return companyList;
	}
	
}
