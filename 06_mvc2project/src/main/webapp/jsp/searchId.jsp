<%@page import="kr.or.iei.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //servlet이 보내준 데이터를 꺼내오는 작업
    //servelt이 보내준 데이터는 형태가 다양하기 때문에 항상 Object타입
    //따라서 사용하고 싶은 객체 타입으로 DownCasting(형변환)해줘야한다.
    Member m = (Member)request.getAttribute("m");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(m != null) {%>
	<ul>
		<li>회원번호 : <%=m.getMemberNo() %></li>
		<li>아이디 : <%=m.getMemberId() %></li>
		<li>비밀번호 : <%=m.getMemberPw() %></li>
		<li>회원이름 : <%=m.getMemberName() %></li>
		<li>회원전화번호 : <%=m.getMemberPhone() %></li>
		<li>회원주소 : <%=m.getMemberAddr() %></li>
		<%if(m.getMemberLevel()==1) {%>
		<li>관리자</li>
		<%}else if (m.getMemberLevel()==2) {%>
		<li>정회원</li>
		<%}else if (m.getMemberLevel()==3) {%>
		<li>준회원</li>
		<%} %>
		<li>가입일 :  <%=m.getEnrollDate() %></li>
	</ul>
	<%}else{ %>
	<h1>회원 정보를 조회할 수 없습니다.</h1>
	<%} %>
</body>
</html>