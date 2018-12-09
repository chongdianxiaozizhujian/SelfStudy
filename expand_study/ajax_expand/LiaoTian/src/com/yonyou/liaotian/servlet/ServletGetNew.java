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
		//获取获取finalMessageId
		String finalMessageId = request.getParameter("finalMessageId");
		//根据finalMessageId获取最新聊天信息
		MessageDao messageDao = new MessageDao();
		List<Message> newMessage = messageDao.getNewMessage(finalMessageId);
		//将聊天信息转换为JSON数据格式返回
		Gson gson = new Gson();
		String json = gson.toJson(newMessage);
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(json);
	}

}
