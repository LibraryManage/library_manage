<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>Ec_Travel-管理员登录</title> 
<link href="Admin/Login/login.css" type="text/css" rel="stylesheet"> 
</head> 
<body> 

<div class="login">
	<div id="contents" class="contents">${err_msg}</div>
    <div class="message">Ec_Travel-管理员登录</div>
    <div id="darkbannerwrap"></div>
    
    <form method="post" action="login.jhtm">
		<input name="action" value="login" type="hidden">
		<input name="account" placeholder="用户名" required="" type="text">
		<hr class="hr15">
		<input name="password" placeholder="密码" required="" type="password">
		<hr class="hr15">
		<input value="登录" style="width:100%;" type="submit">
		<hr class="hr20">
		<!-- 帮助 <a onClick="alert('请联系管理员')">忘记密码</a> -->
	</form>

	
</div>

<div class="copyright">by<a target="_blank"> Ec_Travel全体成员</a></div>

</body>
</html>