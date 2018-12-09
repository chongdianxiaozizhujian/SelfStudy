package com.yonyou.liaotian.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yonyou.liaotian.bean.Message;
import com.yonyou.liaotian.dao.MessageDao;

public class ServletSay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ���͵�������Ϣ
		String msg = request.getParameter("message");
		Message message = new Message(null, msg, new Date());
		//��������Ϣ���浽���ݿ���
		MessageDao messageDao = new MessageDao();
		messageDao.saveMessage(message);
	}

}