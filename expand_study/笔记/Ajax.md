#### Ajax

##### 一、什么是Ajax

Asynchronous JavaScript and XML

浏览器与服务器之间进行异步交互无需刷新页面的技术

##### 二、能用来做什么

1.Google Suggest

2.Google Maps

3.注册用户名验证

4.三级联动(如收获地址市县镇三级联动)

##### 三、为什么用它

传统的交互方式:由浏览器发出请求,服务器返回整个页面

Ajax的交互方式:由XMLHTTPRequest对象收发请求,不惊动浏览器

##### 四、怎么用

①创建web工程Ajax

②创建JSP文件，命名为ajax01JS.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">button {width: 200px;}</style>
<script type="text/javascript">
function getRequest() {
    var xmlHttp = null;
    try {// Chrome, Firefox, Opera, Safari
        xmlHttp = new XMLHttpRequest();
    } catch (e) {
        try {// Internet Explorer
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {// Internet Explorer
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                alert("your browser not support ajax!");
            }
        }
    }
    return xmlHttp;
}
var request = getRequest();
window.onload = function() {
	var btn01Ele = document.getElementById("btn01");
	btn01Ele.onclick = function() {
		alert(request);
	};
	var btn02Ele = document.getElementById("btn02");
	btn02Ele.onclick = function() {
		//发送get请求
		//1.调用XMLHttpRequest对象的open()方法建立一个连接
		//①method参数：请求方式
		//②url参数：请求的目标地址
		//发送请求参数：拼接在url地址后面
		request.open("get", "AjaxRequestServlet?userName=chongdianxiaozi");
		//2.调用XMLHttpRequest对象的send()方法发送请求数据
		request.send();
	};
	var btn03Ele = document.getElementById("btn03");
	btn03Ele.onclick = function() {
		//发送post请求
		request.open("post", "AjaxRequestServlet");
		//post方式需要设置请求头信息
		//Content-Type: application/x-www-form-urlencoded
		request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		//发送请求参数：将请求参数以键值对传递给send()方法
		request.send("age=25");
	};
	var btn04Ele = document.getElementById("btn04");
	btn04Ele.onclick = function() {
		request.open("post", "AjaxResponseText");
		request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		request.send("userName=chongdianxiaozi&age=25");
		//接收【文本】格式的响应数据
		//1.通过onreadystatechange事件监听readystate属性值的变化
		request.onreadystatechange = function() {
			//2.readystate属性值为4且status属性值为200时接收响应数据
			//readystate:返回XMLHTTP请求的当前状态
			//0 (未初始化) 对象已建立，但是尚未初始化（尚未调用open方法） 
			//1 (初始化)  对象已建立，尚未调用send方法 
			//2 (发送数据) send方法已调用，但是当前的状态及http头未知 
			//3 (数据传送中) 已接收部分数据，因为响应及http头不全，这时通过responseBody和responseText获取部分数据会出现错误， 
			//4 (完成) 数据接收完毕,此时可以通过通过responseBody和responseText获取完整的回应数据 
			//status:返回当前请求的http状态码
			if(request.readyState == 4 && request.status == 200) {
				var result = request.responseText;
				alert(result);
				alert(typeof result);
			}
		};
	};
	var btn05Ele = document.getElementById("btn05");
	btn05Ele.onclick = function() {
		request.open("post", "AjaxResponseXML");
		request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		request.send("userName=chongdianxiaozi&age=25");
		//接收【XML】格式的响应数据
		request.onreadystatechange = function() {
			if(request.readyState == 4 && request.status == 200) {
				var result = request.responseXML;
				alert(result);
				alert(typeof result);
				var userName = result.getElementsByTagName("userName")[0].firstChild.nodeValue;
				var age = result.getElementsByTagName("age")[0].firstChild.nodeValue;
				//var temp = result.getElementsByTagName("userName")[0].firstChild;
				//alert(temp);
				alert(userName + " " + age);
			}
		};
	};
	var btn06Ele = document.getElementById("btn06");
	btn06Ele.onclick = function() {
		request.open("post", "AjaxResponseJSON");
		request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		request.send("userName=chongdianxiaozi&age=25");
		//接收【JSON】格式的响应数据
		request.onreadystatechange = function() {
			if(request.readyState == 4 && request.status == 200) {
				var result = request.responseText;
				alert(result);
				alert(typeof result);//string
				//直接接收到的JSON数据是一个字符串类型的数据,需要转换为JSON对象格式
				result = eval("(" + result + ")");
				alert(result);
				alert(result[0].userName + " " + result[1].age);
			}
		};
	};
}
</script>
</head>
<body>
	<center>
		<button id="btn01">获取XMLHttpRequest对象</button><br />
		<button id="btn02">发送GET请求</button><br />
		<button id="btn03">发送POST请求</button><br />
		<button id="btn04">接收【文本】格式的响应数据</button><br />
		<button id="btn05">接收【XML】格式的响应数据</button><br />
		<button id="btn06">接收【JSON】格式的响应数据</button><br />
		<br /><br /><br />
		<form action="AjaxRequestServlet" method="post">
			<input type="text" name="age" /><input type="submit"/>
		</form>
	</center>
</body>
</html>
```

③创建servlet

AjaxRequestServlet.java

```java
package com.yonyou.ajax.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AjaxRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		System.out.println("userName=" + userName);
		System.out.println("AjaxRequestServlet get...");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String age = request.getParameter("age");
		System.out.println("age=" + age);
		System.out.println("AjaxRequestServlet post...");
	}
}
```

AjaxResponseText.java

```java
package com.yonyou.ajax.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AjaxResponseText extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String age = request.getParameter("age");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.write(userName + " " + age + "AjaxResponseText...");
	}
}
```

AjaxResponseXML.java

```java
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
```

AjaxResponseJSON.java

```java
package com.yonyou.ajax.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AjaxResponseJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String age = request.getParameter("age");
		String jsonStr = "[{userName:'" + userName + "'},{age:'" + age + "'}]";
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.write(jsonStr);
	}
}
```

④web.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>Ajax</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  <servlet>
    <description></description>
    <display-name>AjaxRequestServlet</display-name>
    <servlet-name>AjaxRequestServlet</servlet-name>
    <servlet-class>com.yonyou.ajax.servlet.AjaxRequestServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>AjaxRequestServlet</servlet-name>
    <url-pattern>/AjaxRequestServlet</url-pattern>
  </servlet-mapping>
  <servlet>
    <description></description>
    <display-name>AjaxResponseText</display-name>
    <servlet-name>AjaxResponseText</servlet-name>
    <servlet-class>com.yonyou.ajax.servlet.AjaxResponseText</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>AjaxResponseText</servlet-name>
    <url-pattern>/AjaxResponseText</url-pattern>
  </servlet-mapping>
  <servlet>
    <description></description>
    <display-name>AjaxResponseXML</display-name>
    <servlet-name>AjaxResponseXML</servlet-name>
    <servlet-class>com.yonyou.ajax.servlet.AjaxResponseXML</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>AjaxResponseXML</servlet-name>
    <url-pattern>/AjaxResponseXML</url-pattern>
  </servlet-mapping>
  <servlet>
    <description></description>
    <display-name>AjaxResponseJSON</display-name>
    <servlet-name>AjaxResponseJSON</servlet-name>
    <servlet-class>com.yonyou.ajax.servlet.AjaxResponseJSON</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>AjaxResponseJSON</servlet-name>
    <url-pattern>/AjaxResponseJSON</url-pattern>
  </servlet-mapping>
</web-app>
```



##### 五、原理是什么

Ajax原理:

![360截图1645070693118144](E:\expand_study\笔记\note_images\360截图1645070693118144.png)

接收响应的时机:

![360截图16261008637688](E:\expand_study\笔记\note_images\360截图16261008637688.png)



##### 六、注意点有哪些

##### 七、拓展JSON数据

JSON数据：

1.最外层只能是{}或[]

2.{}表示JSON对象：{key1:value1,key2:value2,...,keyn:valuen}

3.[]表示JSON数组：[value1,value2,...,valuen]

4.key数据类型：字符串；

   value数据类型：基本数据类型(数值，字符串，布尔值)

​                                引用数据类型(数组，对象)

5.优势：数据量小，解析速度快，JavaScript直接支持的数据格式，解析方便

##### 八、jQuery如何发送ajax请求

1.方法详解

![360截图16570205475635](E:\expand_study\笔记\note_images\360截图16570205475635.png)

2.具体代码

web工程需要引入Gson.jar和jquery-1.7.2(版本号).js

ajax02jQuery.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("button").click(function() {
			//$.post()方法
			//url:发送请求地址。
			//data:待发送 Key/value 参数。
			//callback:发送成功时回调函数。
			//type:返回内容格式，xml, html, script, json, text, _default。
			$.post("AjaxjQueryServlet",{userName:"chongdianxiaozi"},function(data) {
				alert(data.userName);
			},"json");
		});
	});
</script>
</head>
<body>

	<center>
		<button>$.post()方法解析JSON数据</button>
	</center>

</body>
</html>
```

AjaxjQueryServlet.java

```java
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
```

#### 仿Google搜索

##### 一、创建web工程

添加gson-2.2.4.jar，jquery-1.7.2.js，在WebContent下创建

image文件夹，style文件夹(css文件夹)

##### 二、css.css文件

```css
@CHARSET "UTF-8";
img {
	display: block;
	margin-left: auto;
	margin-right: auto;
	margin-top: 150px;
}

#query {
	display: block;
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
	
	border: 1px solid black;
	
	width: 500px;
	height: 40px;
	
	font-size: 30px;
}

#resultDiv {
	display: none;
	margin-left: auto;
	margin-right: auto;
	width: 500px;
	border-left: 1px solid black;
	border-right: 1px solid black;
	border-bottom: 1px solid black;
}

.itemDiv {
	
}
```

##### 三、query.html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/css.css" />
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		//获取焦点
		$("#query").focus(function() {
			//1.获取当前文本框输入的内容
			var content = $.trim(this.value);
			//2.判断文本框输入内容是否为默认值
			if(content == this.defaultValue) {
				//3.如果是默认值则删除
				this.value = "";
			}
		}).blur(function() {
			//失去焦点
			var content = $.trim(this.value);
			//1.判断文本框输入内容是否为空字符串
			if(content == "") {
				this.value = this.defaultValue;
			}
		}).keyup(function() {
			//change()用于文本输入框时，事件不会随着文字的输入而触发，而是等到文本框失去焦点时才会触发，没有即时性
			//在IE下，可以使用propertychange()，当文本框有任何变化时，能立即触发此事件
			//在其他浏览器(如谷歌)，可以使用keyup()
			//文本框输入内容改变时发送ajax请求
			//1.获取查询关键字
			var keyWords = $.trim(this.value);
			//将jQuery对象在页面上显示慢慢收起
			$("#resultDiv").slideUp(500,function() {
				//2.发送ajax请求
				//url:发送请求地址。
				//data:待发送 Key/value 参数。
				//callback:发送成功时回调函数。
				//type:返回内容格式，xml, html, script, json, text, _default。
				$.post("QueryServlet",{"queryStr":keyWords},function(data) {
					//填充数据之前清空div数据
					$("#resultDiv").empty();
					if(data.length == 0) {
						$("#resultDiv").append("<div>没有查到有关数据</div>")
					}else {
						for(var i = 0; i < data.length; i++) {
							//将解析得到的结果填充到#resultDiv中
							$("#resultDiv").append("<div>"+data[i].companyName+"</div>");
						}
					}
					//$("#resultDiv").show();
					$("#resultDiv").slideDown(500);
				},"json");
			});
		});
	});
</script>
</head>
<body>

	<img src="image/logo.gif" />

	<input type="text" id="query" value="在这里输入查询关键字" />
	
	<div id="resultDiv"></div>

</body>
</html>
```

##### 四、web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>GoogleSuggest</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  <servlet>
    <description></description>
    <display-name>QueryServlet</display-name>
    <servlet-name>QueryServlet</servlet-name>
    <servlet-class>com.yonyou.suggest.QueryServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>QueryServlet</servlet-name>
    <url-pattern>/QueryServlet</url-pattern>
  </servlet-mapping>
</web-app>
```

##### 五、QueryServlet.java

```java
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
		//1.从请求参数中获取查询关键字
		String queryStr = request.getParameter("queryStr");
		System.out.println(queryStr);
		//2.根据查询关键字获取查询结果
		List<Company> queryList = CompanyDao.queryList(queryStr);
		//3.将查询结果转换为json数据格式
		Gson gson = new Gson();
		String json = gson.toJson(queryList);
		//4.将json数据作为响应数据返回
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(json);
	}
}

```

##### 六、Company.java

```java
package com.yonyou.suggest.bean;

public class Company {
	
	private Integer companyId;
	private String companyName;

	public Company() {
		
	}

	public Company(Integer companyId, String companyName) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName="
				+ companyName + "]";
	}
}
```

##### 七、CompanyDao.java

```java
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
```

#### Ajax实现聊天小工具

##### 一、创建web工程

添加gson-2.2.4.jar，c3p0-0.9.1.2.jar，commons-beanutils-1.8.0.jar，commons-dbutils-1.3.jar，commons-logging.jar，mysql-connector-java-5.0.8-bin.jar，jquery-1.7.2.js，dateFormate.js，在WebContent下创建

image文件夹，style文件夹(css文件夹)

##### 二、css.css文件

```css
@CHARSET "UTF-8";
img {
	display: block;
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
	margin-bottom: 50px;
}

#showMessage {
	border: 1px solid black;
	width: 500px;
	height: 200px;
	margin-left: auto;
	margin-right: auto;
	overflow: scroll;
	overflow-x:hidden;
	
	word-wrap: break-word;
	word-break: normal;
}

#sendMessage {
	border: 1px solid black;
	width: 500px;
	height: 100px;
	margin-top: 10px;
	margin-left: auto;
	margin-right: auto;
	display: block;
}

#buttonDiv {
	text-align: center;
	margin-top: 50px;
	margin-bottom: 50px;
}
```

##### 三、index.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/" />
<link rel="stylesheet" type="text/css" href="style/css.css" />
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript" src="script/dateFormate.js"></script>
<script type="text/javascript">
	$(function() {
		//显示聊天信息
		//保存当前本地最新的聊天记录的id值
		var finalMessageId = 0;
		askForNew();
		//访问服务器是否存在新的聊天信息
		function askForNew() {
			$.post("ServletAsk",{"finalMessageId":finalMessageId},function(hasNew) {
				if(hasNew == "true") {
					//向服务器发送请求，获取最新聊天信息
					//alert("ok");
					getNew();
				}
			},"text");
			//每一秒中请求服务器一次
			setTimeout(askForNew, 1000);
		}
		//获取最新聊天信息
		function getNew() {
			var $showMessage = $("#showMessage");
			$.post("ServletGetNew",{"finalMessageId":finalMessageId},function(newMessage) {
				for(var i = 0; i < newMessage.length; i++) {
					var messageId = newMessage[i].messageId;
					var message = newMessage[i].message;
					var messageTime = newMessage[i].messageTime;
					messageTime = new Date(messageTime).Format("yyyy年MM月dd日 hh:mm:ss");
					var htmlStr = "<div>" + messageTime + " " + message + "</div>";
					//$("#showMessage").append(htmlStr);
					$showMessage.append(htmlStr);
					finalMessageId = messageId;
				}
				//获取#showMessage对应的DOM对象，通过scrollTop属性设置滚动条的显示位置
				//设置相对滚动条顶部的偏移
				$showMessage[0].scrollTop = 10000000;
			},"json");
		}
		
		//保存聊天信息
		//给多行文本框绑定键盘按下事件
		$("#sendMessage").keypress(function(event) {
			//按下回车键，发送聊天消息
			//通过事件对象的keyCode属性获取按键对应的ASCII马值
			//alert(event.keyCode);
			//按下回车键，发送聊天信息
			if(event.keyCode == 13) {
				//获取聊天信息数据
				var message = $.trim(this.value);
				//ajax请求发送聊天信息到服务器
				$.post("ServletSay",{"message":message});
				//清空多行文本框
				this.value = "";
			}
		});
	});
</script>
</head>
<body>

	<img src="image/logo.gif" />

	<div id="showMessage"></div>
	<textarea id="sendMessage"></textarea>

</body>
</html>
```

##### 四、web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>LiaoTian</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  <servlet>
    <description></description>
    <display-name>ServletSay</display-name>
    <servlet-name>ServletSay</servlet-name>
    <servlet-class>com.yonyou.liaotian.servlet.ServletSay</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>ServletSay</servlet-name>
    <url-pattern>/ServletSay</url-pattern>
  </servlet-mapping>
  <servlet>
    <description></description>
    <display-name>ServletGetNew</display-name>
    <servlet-name>ServletGetNew</servlet-name>
    <servlet-class>com.yonyou.liaotian.servlet.ServletGetNew</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>ServletGetNew</servlet-name>
    <url-pattern>/ServletGetNew</url-pattern>
  </servlet-mapping>
  <servlet>
    <description></description>
    <display-name>ServletAsk</display-name>
    <servlet-name>ServletAsk</servlet-name>
    <servlet-class>com.yonyou.liaotian.servlet.ServletAsk</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>ServletAsk</servlet-name>
    <url-pattern>/ServletAsk</url-pattern>
  </servlet-mapping>
</web-app>
```

##### 五、c3p0-config.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<c3p0-config>
	<named-config name="webDataSource">
	
		<property name="jdbcUrl">jdbc:mysql://localhost:3306/liaotian</property>
		<property name="driverClass">com.mysql.jdbc.Driver</property>
		<property name="user">root</property>
		<property name="password">root</property>

		<!-- 最小的连接数 -->
		<property name="minPoolSize">5</property>
		<!-- 最大的连接数 -->
		<property name="maxPoolSize">30</property>
		<!-- 初始化的连接数 -->
		<property name="initialPoolSize">10</property>
		<!-- 需要时一次性创建的连接数 -->
		<property name="acquireIncrement">5</property>
		<!-- 缓存多少个Statement对象 -->
		<property name="maxStatements">15</property>

	</named-config>
</c3p0-config>
```

##### 六、Message.java

```java
package com.yonyou.liaotian.bean;

import java.util.Date;

public class Message {
	
	private Integer messageId;
	private String message;
	private Date messageTime;
	
	public Message() {
		
	}

	public Message(Integer messageId, String message, Date messageTime) {
		super();
		this.messageId = messageId;
		this.message = message;
		this.messageTime = messageTime;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", message=" + message
				+ ", messageTime=" + messageTime + "]";
	}

	public Date getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

```



##### 七、BaseDao.java

```java
package com.yonyou.liaotian.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.yonyou.liaotian.utils.JDBCUtils;

/**
 * Dao基类
 * 增删改查
 * @author Administrator
 *
 */
public class BaseDao<T> {
	
	private QueryRunner runner = new QueryRunner();
	
	private Class<T> beanType = null;
	
	public BaseDao() {
		Class clazz = this.getClass();
		
		Class superclass = clazz.getSuperclass();
		
		Type type = clazz.getGenericSuperclass();
		
		if(type instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) type;
			Type[] typeArguments = pt.getActualTypeArguments();
			Type realType = typeArguments[0];
			if(realType instanceof Class) {
				beanType = (Class<T>) realType;
			}
		}
		
	}
	
	public Integer insertWithId(String sql, Object ... param) {
		Integer id = null;
		
		//1.获取数据库连接
		Connection connection = JDBCUtils.getConnection();
		
		//2.获取PreparedStatement对象
		PreparedStatement ps = null;
		
		//3.获取ResultSet对象用来保存返回的自增ID的值
		ResultSet rs = null;
		
		try {
			//在获取PreparedStatement对象时，通过附加另外一个参数的方式将PreparedStatement对象
			//设置为返回自增主键的模式
			ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i+1, param[i]);
			}
			ps.execute();
			
			//自增的主键是以结果集形式返回的
			rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				id = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			//4.释放资源
			JDBCUtils.releaseConnection(connection);
			
			try {
				DbUtils.close(ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				DbUtils.close(rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return id;
	}
	
	/**
	 * 执行批量更新操作
	 * @param sql
	 * @param params 执行批量操作时的SQL语句的参数，是二维数组类型
	 * 在非批量处理的情况下，SQL语句的参数是一维数组，对应SQL语句的一次执行
	 * 在批量处理的情况下，SQL语句的参数是二维数组，对应SQL语句的多次执行
	 * 		其中每一个一维数组和一条SQL语句是对应的
	 * 		第二维数组的每一个元素分别对应SQL语句中的一个参数
	 */
	public void batchUpdate(String sql, Object [] ... params ) {
		Connection connection = JDBCUtils.getConnection();
		try {
			runner.batch(connection, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtils.releaseConnection(connection);
	}
	
	/**
	 * 获取单一值的方法，声明的泛型参数是根据接收返回值的变量的类型传入的
	 * 如果执行的是COUNT()函数需要注意它返回的是Long包装类型
	 * @param sql
	 * @param params
	 * @return
	 */
	public <E> E getSingleValue(String sql, Object ... params) {
		E e = null;
		
		Connection connection = JDBCUtils.getConnection();
		try {
			e = (E) runner.query(connection, sql, new ScalarHandler(), params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		JDBCUtils.releaseConnection(connection);
		
		return e;
	}
	
	/**
	 * 查询数据库返回实体类对象的集合
	 * @param sql
	 * @param params
	 * @return实体类对象的集合
	 */
	public List<T> getBeanList(String sql, Object ... params) {
		
		Connection connection = JDBCUtils.getConnection();
		
		List<T> list = null;
		
		try {
			list = runner.query(connection, sql, new BeanListHandler<>(beanType), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JDBCUtils.releaseConnection(connection);
		
		return list;
		
	}
	
	/**
	 * 返回单一对象的查询方法
	 * @param sql
	 * @param params
	 * @return 将数据库查询结果封装得到的对象
	 */
	public T getBean(String sql, Object ... params) {
		T t = null;
		
		Connection connection = JDBCUtils.getConnection();
		try {
			t = runner.query(connection, sql, new BeanHandler<>(beanType), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtils.releaseConnection(connection);
		
		return t;
	}
	
	/**
	 * 执行增删改的通用方法
	 * @param sql
	 * @param params
	 */
	public void update(String sql, Object ... params) {
		
		Connection connection = JDBCUtils.getConnection();
		try {
			runner.update(connection, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtils.releaseConnection(connection);
		
	}

}

```



##### 八、MessageDao.java

```java
package com.yonyou.liaotian.dao;

import java.util.List;

import com.yonyou.liaotian.bean.Message;

public class MessageDao extends BaseDao<Message>{
	
	//将聊天记录信息保存到数据库中
	public void saveMessage(Message message) {
		String sql = "INSERT INTO MESSAGE (MESSAGE_CONTENT,MESSAGE_TIME) VALUES(?,?)";
		this.update(sql, message.getMessage(), message.getMessageTime());
	}
	
	//根据浏览器传入的本地最新消息ID查询比本地消息还要新的聊天记录
	public List<Message> getNewMessage(String finalMessageId) {
		String sql = "SELECT `MESSAGE_ID` messageId,`MESSAGE_CONTENT` message,`MESSAGE_TIME` messageTime FROM `message` WHERE MESSAGE_ID>? ORDER BY MESSAGE_ID";
		return this.getBeanList(sql, finalMessageId);
	}
	
	//根据浏览器传入的本地最新消息ID查询是否存在新的聊天记录
	public boolean hasNew(String finalMessageId) {
		String sql = "SELECT COUNT(*) FROM `message` WHERE `MESSAGE_ID`>?";
		long count = this.getSingleValue(sql, finalMessageId);
		return count > 0;
	}

}

```



##### 九、ServletAsk.java

```java
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

```



##### 十、ServletGetNew.java

```java
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

```



##### 十一、ServletSay.java

```java
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
		//获取发送的聊天信息
		String msg = request.getParameter("message");
		Message message = new Message(null, msg, new Date());
		//将聊天信息保存到数据库中
		MessageDao messageDao = new MessageDao();
		messageDao.saveMessage(message);
	}

}

```



##### 十二、JDBCUtils.java

```java
package com.yonyou.liaotian.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	
	//数据源是一个非常消耗内存的对象，如果每一次获取数据库连接都创建一个新的，会很快耗尽内存
	//所以声明为static，保证其在项目运行时只有一个实例
	private static DataSource dataSource = new ComboPooledDataSource("webDataSource");
	
	/**
	 * 从数据库连接池中获取数据库连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	/**
	 * 释放数据库连接
	 * @param connection
	 */
	public static void releaseConnection(Connection connection) {
		
		//判断是否为空，避免空指针异常
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}

```



##### 十三、MyDateConvert

```java
package com.yonyou.liaotian.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
public class MyDateConvert implements Converter{
    public Object convert(Class type, Object value){
        if(value == null){
            return null;
        }else if(type == Timestamp.class){
            return convertToDate(type, value, "yyyyMMddHH:mm:ss");
        }else if(type == Date.class){
            return convertToDate(type, value, "yyyy-MM-dd");
        }else if(type == String.class){
            return convertToString(type, value);
        }

        throw new ConversionException("不能转换 " + value.getClass().getName() + " 为 " + type.getName());
    }

    protected Object convertToDate(Class type, Object value, String pattern) {
    	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        if(value instanceof String){
            try{
                Date date = sdf.parse((String) value);
                if(type.equals(Timestamp.class)){
                    return new Timestamp(date.getTime());
                }
                return date;
            }catch(Exception pe){
                return null;
            }
        }else if(value instanceof Date){
        	return value;
        }
        
        throw new ConversionException("不能转换 " + value.getClass().getName() + " 为 " + type.getName());
    }

    protected Object convertToString(Class type, Object value) {
        if(value instanceof Date){
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	
            if (value instanceof Timestamp) {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            } 
            
            try{
                return sdf.format(value);
            }catch(Exception e){
                throw new ConversionException("日期转换为字符串时出错！");
            }
        }else{
            return value.toString();
        }
    }
}
```

##### 十四、数据库建库建表sql

```mysql
CREATE DATABASE /*!32312 IF NOT EXISTS*/`liaotian` /*!40100 DEFAULT CHARACTER SET gb2312 */;
USE `liaotian`;
/*Table structure for table `message` */
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `MESSAGE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MESSAGE_CONTENT` char(255) DEFAULT NULL,
  `MESSAGE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`MESSAGE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=306 DEFAULT CHARSET=gb2312;
```

