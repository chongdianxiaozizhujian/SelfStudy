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