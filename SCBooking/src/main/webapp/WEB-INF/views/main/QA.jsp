<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SCBooking - Q&A</title>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/mainPage.jsp"%>
<script>
$(function(){
	$("#btnNewBoard").on("click",function(){
		location.href = "${path}/main/QA/newBoard";
	});
});
</script>
</head>
<body>
	<div id="menuElement">
		<div id="QAZone">
			<h1>Q&A</h1>
			<div>
				<input id="inputSearch"> 
				<input type="button" value="검색" id="btnSearch">
				<input type="button" value="새글등록" id="btnNewBoard">
			</div>
			<div>
				<table id="listTable">
					<tr id="listTitleZone">
						<th>번호</th>
						<th style="width: 600px;">제목</th>
						<th>작성자</th>
						<th style="width: 300px">작성일</th>
					</tr>
					<c:forEach var="row" items="${list}">
						<tr>
							<td>${row.bno}</td>
							<td><a href="${path}/main/QA/readBoard?bno=${row.bno}">${row.title}</a></td>
							<td>${row.writer}</td>
							<td>${row.register_date}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="paginationZone">
				<ul id="pagination">
					<li>이전</li>
					<li>1</li>
					<li>2</li>
					<li>3</li>
					<li>4</li>
					<li>5</li>
					<li>6</li>
					<li>다음</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>