<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>SCBooking - Main</title>
  <link href="https://fonts.googleapis.com/css?family=Courgette&display=swap" rel="stylesheet">
  <link href="${path}/resources/css/main.css?ver=1" rel="stylesheet">
  <script>
  	$(function(){
  		$("#btnLogout").click(function(){
  			location.href="${path}/member/logout";
  		});
  	});
  </script>
  </head>
  <body>
    <div id="titleBox">
      <span id="title">SCBooking</span>
    </div>
    <div id="logAndMenu">
      <div id="log">
         	 ${sessionScope.name}님 <br>환영합니다.<br>
          <input type="button" id="btnLogout" value="로그아웃">
      </div>
      <div id="menu">
        <ul>
          <li><a href="/main/booking">예약</a>
          <li><a href="#">공지사항</a>
          <li><a href="/main/QA/">Q&A</a>
          <li><a href="#">마이페이지</a>
        </ul>
      </div>
    </div>
  </body>
</html>
