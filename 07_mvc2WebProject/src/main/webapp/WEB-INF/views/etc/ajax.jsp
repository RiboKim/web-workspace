<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.ajaxResult{
		min-height: 100px;
		border : 2px solid #ccc;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">AJAX</div>
		<h3>1. 서버호출하기</h3>
		<a class="btn bc11" href="/ajaxTest1.do">a태그방식</a>
		<button class="btn bc11" id="js">JS방식</button>
		<button class="btn bc11" id="jQ1">jQuery방식</button>
		
		<h3>2. 서버로 값 전송하기</h3>
		<input type="text">
		<button class="btn bc11" id="jQ2">전송</button>
		
		<h3>3. 서버로 데이터 전송하고 서버에서 데이터받기(기본형 데이터받기)</h3>
		<input type="text" id="su1">
		<input type="text" id="su2">
		<button class="btn bc1" id="jQ3">더하기</button>
		<p class="ajaxResult" id="result3"></p>
		
		<h3>4. 서버로 데이터전송하고 서버에서 데이터받기(객체 받기)</h3>
		<input type="text" id="input4">
		<button class="btn bc1" id="jQ4">회원정보조회</button>
		<p class="ajaxResult" id="result4"></p>
		
		<h3>5. 서버에서 리스트 데이터 받기</h3>
		<button class="btn bc1" id="jQ5">전체회원조회</button>
		<p class="ajaxResult" id="result5"></p>
		
		<h3>6. 서버로 데이터 전송하고 서버에서 데이터받기(GSON)</h3>
		<input type="text" id="input6">
		<button class="btn bc1" id="jQ6">회원정보조회</button>
		<p class="ajaxResult" id="result6"></p>
		
		<h3>7. 서버에서 데이터 리스트 받기(GSON)</h3>
		<button class="btn bc1" id="jQ7">전체회원조회</button>
		<p class="ajaxResult" id="result7"></p>
	</div>
	<script>
		$("#js").on("click",function(){
			//javascript로 ajax를 이용한 서버호출방식
			//1.XMLHttpRequest객체 생성
			const xhttp = new XMLHttpRequest();
			//2.요청 정보 설정
			//method, url, 비동기여부
			xhttp.open("GET","/ajaxTest1.do",true);
			//3.서버 요청 처리에 따른 동작함수 지정
			xhttp.onreadystatechange = function(){
				if(this.readyState == 4 && this.status == 200){
					//요청이 모두 끝나고 && 정상적인 응답이 돌아온 경우
					console.log("서버 요청 성공!!");
				}else if(this.readyState == 4 && this.status == 404){
					//요청이 모두 끝나고 && 해당 페이지를 찾을 수 없는 경우
					console.log("주소를 찾을 수 없습니다.");
				}
			}
			//4.서버에 요청
			xhttp.send();
		});
		
		$("#jQ1").on("click",function(){
			$.ajax({
				url : "/ajaxTest1.do",
				type : "GET",
				success : function(){
					console.log("서버 호출 완료!!!!");
				},
				error : function(){
					console.log("에러발생");
				},
				complete : function(){
					console.log("무조건 호출");
				}
			});
		});
		
		$("#jQ2").on("click",function(){
			const input = $(this).prev();
			const inputValue = input.val();
			$.ajax({
				url : "/ajaxTest2.do",
				type : "get",
				data : {input1 : inputValue}, //input1이 key값이라고 생각하면 됨, 여러개 보내는것도 가능
				success : function(){
					console.log("서버로 데이터 전송 완료");
				},
				error : function(){
					console.log("에러발생");
				}
			});
		});
		$("#jQ3").on("click",function(){
			//input에 입력된 값 2개 가져다가
			// /ajaxTest3.do에 전송후 출력
			const su1 = $("#su1").val();
			const su2 = $(this).prev().val();
			$.ajax({
				url : "ajaxTest3.do",
				type : "post",
				data : {num1 : su1, num2 : su2},
				success : function(data){
					console.log(data, typeof data);
					$("#result3").text(su1+"+"+su2+"="+data);
					console.log("서버요청성공");
					
				},
				error : function(){
					console.log("서버요청 실패")
				}
			});
		});
		$("#jQ4").on("click",function(){
			const memberId = $("#input4").val();
			const result = $("#result4");
			result.empty();//데이터가 쌓이는걸 막는거 없는 아이디를 쳐도 데이터는 쌓이니까
			$.ajax({
				url : "/ajaxTest4.do",
				type : "get",
				data : {memberId : memberId},
				dataType : "JSON", //Servlet에 안 쓸거면 여기에 쓰면 됨
				success : function(data){
					if(data == null){
						result.append("회원 정보를 조회할 수 없습니다.");
					}else{
						result.append("아이디 : "+data.memberId+"<br>");
						result.append("이름 : "+data.memberName+"<br>");
						result.append("전화번호 : "+data.memberPhone+"<br>");
						result.append("주소 : "+data.memberAddr);
					}
				},
				error : function(){
					console.log("서버요청 실패")
				}
			});
		});
		$("#jQ5").on("click",function(){
			const result = $("#result5");
			result.empty();
			$.ajax({
				url : "/ajaxTest5.do",
				type : "get",
				dataType : "json",
				success : function(data){
					for(let i=0;i<data.length;i++){
						const div=$("<div></div>");
						div.append(data[i].memberId);
						div.append("/");
						div.append(data[i].memberName);
						div.append("/");
						div.append(data[i].memberPhone);
						div.append("/");
						div.append(data[i].memberAddr);
						div.append("/");
						result.append(div);
					}
				}
			});
		});
		$("#jQ6").on("click",function(){
			const memberId = $("#input6").val();
			const result = $("#result6");
			result.empty();
			$.ajax({
				url : "/ajaxTest6.do",
				type : "get",
				data : {memberId : memberId},
				dataType : "json",
				success : function(data){
					console.log(data);
				},
				error : function(){
					console.log("서버호출실패");
				}
				
			
			})
		});
		$("#jQ7").on("click",function(){
			const result = $("#result7");
			result.empty();
			$.ajax({
				url : "/ajaxTest7.do",
				type : "get",
				dataType : "json",
				success : function(data){
					console.log(data);
				},
				error : function(){
					console.log("서버호출실패");
				}
			})
		})
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>