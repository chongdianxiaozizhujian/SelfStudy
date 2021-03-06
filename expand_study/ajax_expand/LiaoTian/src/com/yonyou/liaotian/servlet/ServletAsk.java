package com.yonyou.liaotian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yonyou.liaotian.dao.MessageDao;
public class ServletAsk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取获取请求参数：finalMessageId
		String finalMessageId = request.getParameter("finalMessageId");
		//查询是否存在最新的聊天记录
		MessageDao messageDao = new MessageDao();
		boolean hasNew = messageDao.hasNew(finalMessageId);
		//返回数据
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(hasNew+"");
	}

}
