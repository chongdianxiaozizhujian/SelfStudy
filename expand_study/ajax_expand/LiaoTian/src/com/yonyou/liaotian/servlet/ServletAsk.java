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
		//��ȡ��ȡ���������finalMessageId
		String finalMessageId = request.getParameter("finalMessageId");
		//��ѯ�Ƿ�������µ������¼
		MessageDao messageDao = new MessageDao();
		boolean hasNew = messageDao.hasNew(finalMessageId);
		//��������
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(hasNew+"");
	}

}