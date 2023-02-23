<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	th,td{
		border : 1px solid #ccc;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">EMAIL API</div>
		<h3>1. 이메일 전송하기</h3>
		<form action="/mailSend1.do" method="post">
			<table class="tbl">
				<tr class="tr-1">
					<th class="td-2" style="width:20%;">제목</th>
					<td>
						<input type="text" name="mailTitle" class="input-form">
					</td>
				</tr>
				<tr class="tr-1">
					<th class="td-2">수신자메일주소</th>
					<td>
						<input type="text" name="receiver" class="input-form">
					</td>
				</tr>
				<tr>
					<th class="td-2">내용</th>
					<td>
						<textarea name="mailContent" class="input-form"></textarea>
					</td>
				</tr>
				<tr>
					<th colspan="2">
						<button class="btn bc1 bs4" type="submit">메일전송</button>
					</th>
				</tr>
			</table>
		</form>
		<hr>
		<h3>2. 이메일 인증</h3>
		<input type="text" id="email">
		<button class="btn bc1" id="sendBtn">이메일 전송</button>
		<div id="auth" style="display:none;">
			<input type="text" id="authCode" placeholder="인증번호">
			<button class="btn bc1" id="authBtn">인증하기</button>
			<span id="timeZone"></span>
			<span id="authMsg"></span>
		</div>
	</div>
	<script>
		let mailCode;
		$("#sendBtn").on("click",function(){
			const email = $("#email").val();
			$.ajax({
				url : "/sendMail2.do",
				data : {email, email},
				type : "post",
				success : function(data){
					console.log(data);
					if(data == "null"){
						alert("이메일 주소를 확인해주세요");
					}else{
						mailCode = data;
						$("#auth").slideDown();
						authTime();
					}
				},
				error : function(){
					console.log("에러발생");
				}
			});
			
		});
		let intervalId;
		function authTime(){
			$("#timeZone").html("<span id='min'>3</span> : <span id='sec'>00</span>");
			intervalId = window.setInterval(function(){
				timecount();
			},1000)
		}
		function timecount(){
			const min = $("#min").text();
			const sec = $("#sec").text();
			if(sec == "00"){
					if(min != "0"){
						const newMin = Number(min) - 1;
						$("#min").text(newMin);
						$("#sec").text(59);
					}else{
						window.clearInterval(intervalId);
						mailCode = null;
						$("#authMsg").text("인증시간만료");
						$("#authMsg").css("color","red");
					}
				
			}else{
				const newSec = Number(sec) - 1;
				if(newSec<10){
					$("#sec").text("0"+newSec);
				}else{
					$("#sec").text(newSec);
				}
				
			}
		}
		$("#authBtn").on("click",function(){
			if(mailCode == null){
				$("#authMsg").text("인증시간만료");
				$("#authMsg").css("color","red");
			}else{
				const authCode = $("#authCode").val();
				if(mailCode == authCode){
					$("#authCode").prop("readonly",true); //더 이상 인증코드 못 바꾸게 하는거
					$("#authMsg").text("인증완료");
					$("#authMsg").css("color","blue");
					window.clearInterval(intervalId);
				}else{
					$("#authMsg").text("인증실패");
					$("#authMsg").css("color","red");
				}
			}
		})
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>