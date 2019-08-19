<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SCBooking - Q&A Read Board</title>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/mainPage.jsp"%>
</head>
<body>
	<div id="menuElement">
		<div id="readBoardZone">
			<h1>게시번호 ${qaDto.bno}</h1>
			<hr>
			<h3>Title</h3>
			<span>${qaDto.title }</span>
			<h3>Context</h3>
			<div id="contextZone">
				<span>${qaDto.context }</span>
			</div>
			<h3>Writer</h3>
			<span>${qaDto.writer }</span>
		</div>
	</div>
</body>
</html>