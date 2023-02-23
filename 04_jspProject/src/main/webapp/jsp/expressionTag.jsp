<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>표현식태그</h1>
	<hr>
	<h3>자바의 데이터를 HTML 컨텐츠로 표현하기 위해 사용하는 태그</h3>
	<%
		int age = 25;
		ArrayList<String> list = new ArrayList<String>();
		list. add("김건형1");
		list. add("김건형2");
		list. add("김건형3");
		list. add("김건형4");
		list. add("김건형5");
	%>
	<%if(age>19) {%>
	<h3><%=age %>살은 성인입니다</h3>
	<%}else{%>
	<h3><%=age %>살은 미성년자입니다.</h3>
	<%} %>
	<hr>
	<% for(int i=0;i<list.size();i++) {%>
		<h3><%=i %>_<%=list.get(i) %></h3>
		<%} %>
</body>
</html>