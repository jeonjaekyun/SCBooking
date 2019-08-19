<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../include/header.jsp"%>
<title>SCBooking - Resister</title>
<link href="${path}/resources/css/login.css?ver=1" rel="stylesheet">
<script>
	$(function() {
		$("#btnDuplicateCheck").click(function() {
			document.form1.action = "${path}/member/duplicateCheck";
			document.form1.submit();
		});
	});
	$(function(){
		$('#btnRegister').click(function(){
			var userid = document.form1.userid.value;
			var passwd = document.form1.passwd.value;
			var name = document.form1.name.value;
			var email = document.form1.email.value;
			var dCheck = "${msg}";
			
			if(userid==""){
				alert("아이디를 입력하세요");
				document.form1.userid.focus();
				return;
			}
			if(passwd==""){
				alert("비밀번호를 입력하세여");
				document.form1.passwd.focus();
				return;
			}
			if(name==""){
				alert("이름을 입력하세여");
				document.form1.name.focus();
				return;
			}
			if(email==""){
				alert("이메일을 입력하세여");
				document.form1.email.focus();
				return;
			}if(dCheck==""||dCheck=="중복된 아이디"){
				alert("중복체크 해주세요");
				return;
			}
			document.form1.action="${path}/member/register";
			document.form1.submit();
			
		});
	});
</script>
</head>
<body>
	
	<div id="registerBox">
		<form name="form1" action="${path}/member/register" method="post">
			<h1>회원가입</h1>
			<input type="text" name="userid" value="${dto.userid}" 
				placeholder="ID" class="inputArea">
			<input type="password" name="passwd" value="${dto.passwd }" 
				placeholder="PW" class="inputArea">
			<input type="text" name="name" value="${dto.name }" 
				placeholder="NAME" class="inputArea">
			<input type="text" name="email" value="${dto.email}" 
				placeholder="E-mail" class="inputArea">
			<hr>
			<h2 class="msg">${msg}</h2>
			<input type="button" id="btnDuplicateCheck" class="okBtn"
				value="ID 중복체크" bgcolor="red">
			<input type="button" value="회원가입" id="btnRegister" 
				class="okBtn">
		</form>
	</div>
	
</body>
</html>