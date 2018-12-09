package com.yonyou.suggest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yonyou.suggest.bean.Company;
import com.yonyou.suggest.dao.CompanyDao;

public class QueryServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.����������л�ȡ��ѯ�ؼ���
		String queryStr = request.getParameter("queryStr");
		System.out.println(queryStr);
		//2.���ݲ�ѯ�ؼ��ֻ�ȡ��ѯ���
		List<Company> queryList = CompanyDao.queryList(queryStr);
		//3.����ѯ���ת��Ϊjson���ݸ�ʽ
		Gson gson = new Gson();
		String json = gson.toJson(queryList);
		//4.��json������Ϊ��Ӧ���ݷ���
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(json);
	}
}
