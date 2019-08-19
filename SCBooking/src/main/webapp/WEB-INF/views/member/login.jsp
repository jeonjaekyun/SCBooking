<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/header.jsp" %>
<title>SCBooking - Login</title>
<link href="${path}/resources/css/login.css?ver=1" type="text/css" rel="stylesheet">
</head>

<body>
	<div id="logBox">
		<form name="form1" method="post">
			<h1>SCBooking</h1>
			<input type="text" name="userid" placeholder="ID" class="inputArea">
			<input type="password" name="passwd" placeholder="password" class="inputArea">
			<input type="submit" value="로그인" class="okBtn"><br>
			<hr>
			<a href="${path}/member/register">회원가입</a>
			<h4 class="msg">${msg}</h4>
		</form>
	</div>
</body>
</html>