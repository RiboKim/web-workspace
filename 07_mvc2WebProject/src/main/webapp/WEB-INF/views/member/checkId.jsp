<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int result = (int)request.getAttribute("result");
    	String memberId = (String)request.getAttribute("memberId");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/default.css">
<script src="/js/jquery-3.6.0.js"></script>
<style>
	#check-container{
		text-align: center;
		padding-top: 50px;
		width: 250px;
		margin: 0 auto;
	}
	.id-wrap{
		display: flex;
	}
	.id-wrap>input{
		width: 70%;
	}
	.id-wrap>button{
		width: 30%;
	}
</style>
</head>
<body>
	<div id="check-container">
	<%if(result == 0 ) {%>
	<div>
		[<span class="fc-4 f-bold"><%=memberId %></span>]는 사용가능합니다
	</div>
		<br><br>
		<button type="button" class="btn bc1" id="closeBtn">닫기</button>
		
	<script>
	$("#closeBtn").on("click",function(){
		const id = $(".fc-4").text();
		//부모창의 요소를 선택하는 방법
		const inputId = $("#memberId",opener.document);
		inputId.val(id);
		self.close();
	});
	
	</script>
	<%}else if(result == 1) {%>
	<div>
		[<span class="fc-6 f-bold"><%=memberId %></span>]는 사용이 불가능합니다
	</div>
		<br><br>
		<form action="/checkId.do">
			<div class="id-wrap">
				<input type="text" name="checkId" class="input-form">
				<button type="submit" class="btn bc2">조회</button>
			</div>
		</form>
	<%} %>
	</div>
</body>
</html>