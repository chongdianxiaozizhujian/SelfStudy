package com.yonyou.suggest.dao;

import java.util.ArrayList;
import java.util.List;

import com.yonyou.suggest.bean.Company;

public class CompanyDao {
	
	public static final List<Company> COMPANY = new ArrayList<>();
	
	static {
		COMPANY.add(new Company(11, "Ajaxѧϰָ��"));
		COMPANY.add(new Company(12, "��Web��Ŀ��ʹ��Ajax"));
		COMPANY.add(new Company(13, "Ajax�첽����"));
		COMPANY.add(new Company(14, "͸��Ajax����"));
		COMPANY.add(new Company(15, "���Ajax�첽��������"));
		COMPANY.add(new Company(16, "jQuery������Ļ"));
		COMPANY.add(new Company(17, "������jQuery��ܽṹ"));
		COMPANY.add(new Company(18, "jQuery�е�JavaScript����"));
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
