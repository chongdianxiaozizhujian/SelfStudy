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