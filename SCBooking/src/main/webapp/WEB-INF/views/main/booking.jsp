<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SCBooking-booking</title>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/mainPage.jsp"%>
<script>
$(function(){
	$("#bookingBtn").click(function(){
		var userid = "<%=(String) session.getAttribute("userid")%>";
		var roomNum = document.form1.roomNum.value;
		var byear = document.form1.byear.value;
		var bmonth = document.form1.bmonth.value;
		var bday = document.form1.bday.value;
		var bstart = document.form1.bstart.value;
		var bend = document.form1.bend.value;

		if (userid == "null") {
			alert("로그인 후 사용 가능합니다.");
			location.href = "${path}/member/login";
			return;
		}
		if (roomNum == "방번호" || byear == "년" || bmonth == "월"
			|| bday == "일" || bstart == "시작시간" || bend == "종료시간") {
			
			alert("정보를 모두 입력하신 후 예약하실수 있습니다.");
			return;
		}

		$.ajax({
			type:'post',
			url:"/booking",
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"POST"
			},
			dataType:'text',
			data: JSON.stringify({
				userid:userid, roomNum:roomNum,
				byear:byear, bmonth:bmonth, bday:bday,
				bstart:bstart, bend:bend
			}),
			success:function(result){
				if(result=="SUCCESS"){
					alert(userid + " 님 방번호 : " + roomNum + "/ " + byear
							+ "년 " + bmonth + "월 " + bday + "일 " + bstart
							+ ":00~" + bend + ":00시 예약완료 되었습니다.");
					getAllList(roomNum, byear, bmonth, bday);
					
				}else if(result=="FAIL"){
					alert("중복되는 예약이 존재합니다.");
				}
			}
		});
	});
		

		$("#lookupBtn").on("click", function() {
			var roomNum = document.form2.roomNum.value;
			var byear = document.form2.byear.value;
			var bmonth = document.form2.bmonth.value;
			var bday = document.form2.bday.value;
			getAllList(roomNum, byear, bmonth, bday);
		});
	});
	
	function getAllList(roomNum, byear, bmonth, bday){
		$.getJSON("/booking/"+roomNum+"/"+byear+"/"+bmonth+"/"+bday, function(data){
			str = "";
	
			console.log(data.length);
			console.log(data);

			$(data).each(
				function(){
					str +="<tr><td>"
						+this.roomNum+"</td><td>"+this.byear+"</td><td>"
						+this.bmonth+"</td><td>"+this.bday+"</td><td>"
						+this.bstart+"</td><td>"+this.bend+"</td></tr>";
					
			});
			$("#bookingList").html(str);
		});	
	}
</script>
</head>
<body>
<div id="menuElement">
	<div id="roomMap">
		<div class="roomShape">room1</div>
		<div class="roomShape">room2</div>
		<div class="roomShape">room3</div>
		<div class="roomShape">room4</div>
		<br clear="all">
		<div class="hallway">
		DOOR
		<div></div>
		</div>
		<div class="roomShape">room5</div>
		<div class="roomShape">room6</div>
		<div class="roomShape">room7</div>
		<div class="roomShape">room8</div>
	</div><br clear="all">
	<div id="bookingBox">
		<table id="scheduleBox" border="1">
			<tr  id="lookupZone">
				<td colspan="6">
					<form name="form2" method="post">
						<select name="byear" id="year">
							<option>년</option>
							<script>
								for (i = 2019; i <= 2045; i++) {
									document.write("<option value="+i+">" + i
											+ "년</option>");
								}
							</script>
						</select>
						<select name="bmonth" id="month">
							<option>월</option>
							<script>
								for (i = 1; i <= 12; i++) {
									document.write("<option value="+i+">" + i
											+ "월</option>");
								}
							</script>
						</select>
						<select name="bday" id="day">
								<option>일</option>
								<script>
									for (i = 1; i <= 31; i++) {
										document.write("<option value="+i+">" + i
												+ "일</option>");
									}
								</script>
						</select>
						<select name="roomNum" id="roomNum">
							<option>방번호</option>
							<option value="room1">room1</option>
							<option value="room2">room2</option>
							<option value="room3">room3</option>
							<option value="room4">room4</option>
							<option value="room5">room5</option>
							<option value="room6">room6</option>
							<option value="room7">room7</option>
							<option value="room8">room8</option>
						</select>
						<input type="button" id="lookupBtn" value="조회">
					</form>
				</td>
			</tr>
			<tr>
				<th width="120px">방번호</th>
				<th width="100px">년</th>
				<th width="100px">월</th>
				<th width="100px">일</th>
				<th>시작시간</th>
				<th>끝나는시간</th>
			</tr>
			<tbody id="bookingList"></tbody>
			<%--<c:forEach var="row" items="${list}">
				<tr>
					<td>${row.roomNum}</td>
					<td>${row.byear}</td>
					<td>${row.bmonth}</td>
					<td>${row.bday}</td>
					<td>${row.bstart}</td>
					<td>${row.bend}</td>
				</tr>
			</c:forEach>
			<c:forEach begin="${list.size()+1}" end="11">
				<tr></tr>
			</c:forEach>
			<tr>
				<td>시간</td>
				<c:forEach var="i" begin="1" end="8">
					<td>room${i}</td>
				</c:forEach>
			</tr>
			<c:forEach var="i" begin="9" end="17">
				<tr>
					<td>${i} - ${i+1}</td>
					<c:forEach var="j" begin="1" end="8">
						<td>O</td>
					</c:forEach>
				</tr>
			</c:forEach> --%>
		</table>
		<form name="form1" method="post">
			<div id="bookingInput">
				<h1>스터디룸 예약</h1>
				<input type="hidden" name="userid" value="${sessionScope.userid}">
				방번호&nbsp;&nbsp;&nbsp; <select name="roomNum" id="roomNum">
					<option>방번호</option>
					<option value="room1">room1</option>
					<option value="room2">room2</option>
					<option value="room3">room3</option>
					<option value="room4">room4</option>
					<option value="room5">room5</option>
					<option value="room6">room6</option>
					<option value="room7">room7</option>
					<option value="room8">room8</option>
				</select><br>
				<br> 예약날짜 
				<select name="byear" id="byear">
					<option>년</option>
					<script>
						for (i = 2019; i <= 2045; i++) {
							document.write("<option value="+i+">" + i
									+ "년</option>");
						}
					</script>
				</select><span> 
				<select name="bmonth" id="bmonth">
					<option>월</option>
					<script>
						for (i = 1; i <= 12; i++) {
							document.write("<option value="+i+">" + i
									+ "월</option>");
						}
					</script>
				</select><span> 
				<select name="bday" id="bday">
						<option>일</option>
						<script>
							for (i = 1; i <= 31; i++) {
								document.write("<option value="+i+">" + i
										+ "일</option>");
							}
						</script>
				</select><br>
					<br> 예약시간 <select name="bstart" id="bstart">
							<option>시작시간</option>
							<option value="09">09:00</option>
							<option value="10">10:00</option>
							<option value="11">11:00</option>
							<option value="12">12:00</option>
							<option value="13">13:00</option>
							<option value="14">14:00</option>
							<option value="15">15:00</option>
							<option value="16">16:00</option>
							<option value="17">17:00</option>
					</select> <br> <span>~</span> <br> <span></span> <select
						name="bend" id="bend">
							<option>종료시간</option>
							<option value="10">10:00</option>
							<option value="11">11:00</option>
							<option value="12">12:00</option>
							<option value="13">13:00</option>
							<option value="14">14:00</option>
							<option value="15">15:00</option>
							<option value="16">16:00</option>
							<option value="17">17:00</option>
							<option value="18">18:00</option>
					</select> <input type="button" id="bookingBtn" class="okBtn" value="예약">
			</div>
		</form>
	</div>
</div>
</body>
</html>