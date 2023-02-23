<%@page import="kr.or.iei.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //servlet이 보내준 데이터를 꺼내주는 작업
    //servlet이 보내주는 데이터는 항상 object
    //그러므로 원하는 데이터타입으로 변환을 해주어야한다.
    //request.getAttribute("list");여기까지가 object
    //그러니까 ( ) 안에는 내가 원하는 형태가 와야한다.
    ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(list.isEmpty()){%>
	<h2>회원정보를 조회할 수 없습니다.</h2>
	<%} else{ %>
	<h1>전체회원정보</h1>
	<hr>
	<table border="1">
	<tr>
		<th>회원번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>전화번호</th>
		<th>주소</th>
		<th>회원등급</th>
		<th>가입일</th>
	</tr>
	<%for(Member m : list) { %>
	<tr>
		<td><%=m.getMemberNo() %></td>
		<td><%=m.getMemberId() %></td>
		<td><%=m.getMemberPw() %></td>
		<td><%=m.getMemberName() %></td>
		<td><%=m.getMemberPhone() %></td>
		<td><%=m.getMemberAddr() %></td>
		<%if(m.getMemberLevel() == 1) {%>
		<td>관리자</td>
		<%}else if(m.getMemberLevel() == 2){ %>
		<td>정회원</td>
		<%}else if(m.getMemberLevel() == 3) {%>
		<td>준회원</td>
		<%} %>
		<td><%=m.getEnrollDate() %></td>
	</tr>
	
	<%} %>	
	</table>
	
	<%} %>
</body>
</html>