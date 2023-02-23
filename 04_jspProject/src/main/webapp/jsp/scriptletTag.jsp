<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스크립틀릿태그</h1>
	<hr>
	<h3>_jspService 메소드의 수행내용을 작성할때 사용</h3>
	<p>자바 소스코드를 작성하고 싶을 때 사용하는 태그</p>
	<%
		int age = 10;
	%>
	<%if(age>19) {%>
	<p>성인입니다</p>
	<%}else{%>
	<p>미성년자입니다.</p>
	<%} %>
</body>
</html>