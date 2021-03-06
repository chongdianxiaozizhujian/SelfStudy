package com.yonyou.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class AjaxjQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		System.out.println(userName);
		Map<String, String> map = new HashMap<>();
		map.put("userName", userName);
		Gson gson = new Gson();
		String json = gson.toJson(map);
		//设置响应内容类型
		response.setContentType("text/json,charset=UTF-8");
		//获取用于返回数据的字符输出流
		PrintWriter writer = response.getWriter();
		writer.write(json);
	}

}
