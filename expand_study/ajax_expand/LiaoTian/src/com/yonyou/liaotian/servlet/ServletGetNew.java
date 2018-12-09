package com.yonyou.liaotian.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yonyou.liaotian.bean.Message;
import com.yonyou.liaotian.dao.MessageDao;
public class ServletGetNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ��ȡfinalMessageId
		String finalMessageId = request.getParameter("finalMessageId");
		//����finalMessageId��ȡ����������Ϣ
		MessageDao messageDao = new MessageDao();
		List<Message> newMessage = messageDao.getNewMessage(finalMessageId);
		//��������Ϣת��ΪJSON���ݸ�ʽ����
		Gson gson = new Gson();
		String json = gson.toJson(newMessage);
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(json);
	}

}
