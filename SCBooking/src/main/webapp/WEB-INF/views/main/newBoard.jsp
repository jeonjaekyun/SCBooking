<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SCBooking - Q&A New Board</title>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/mainPage.jsp"%>
</head>
<body>
	<div id="menuElement">
		<div id="newBoardZone">
			<h1>새글 등록</h1>
			<hr>
			<form name="form1" method="post">
				<h3>Title</h3>
				<input type="text" name="title">
				<h3>Context</h3>
				<textarea rows="15" cols="75" name="context"></textarea>
				<h3>Writer</h3>
				<input value="${sessionScope.userid}" name="writer" readonly>
				<div id="btnZone">
					<input type="submit" value="등록"> <input type="button" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>