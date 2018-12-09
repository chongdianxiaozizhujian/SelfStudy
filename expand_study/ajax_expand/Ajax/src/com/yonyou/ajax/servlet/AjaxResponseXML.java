package com.yonyou.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AjaxResponseXML extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String age = request.getParameter("age");
		String xmlStr = "<user><userName>" + userName + "</userName>" + "<age>" + age + "</age>" + "</user>";
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.write(xmlStr);
	}

}
