<%@page import="kr.or.iei.model.vo.Member"%>
<%@page import="kr.or.iei.model.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
//1.인코딩
	request.setCharacterEncoding("utf-8");
//2.값추출
	String memberId = request.getParameter("memberId");
//3.비즈니스 로직
	MemberService service = new MemberService();
	Member m = service.selectOneMember(memberId);
//4.결과처리

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(m==null){ %>
	<h2>회원 정보를 조회할 수 없습니다.</h2>
	<%}else{%>
	<ul>
		<li>회원번호 : <%=m.getMemberNo() %></li>
		<li>아이디 : <%=m.getMemberId() %></li>
		<li>비밀번호 : <%=m.getMemberPw() %></li>
		<li>이름 : <%=m.getMemberName() %></li>
		<li>전화번호 : <%=m.getMemberPhone() %></li>
		<li>주소 : <%=m.getMemberAddr() %></li>
		<%if(m.getMemberLevel() == 1) {%>
		<li>회원등급 : 관리자</li>
		<%}else if(m.getMemberLevel() == 2) {%>
		<li>회원등급 : 정회원</li>
		<%}else if(m.getMemberLevel() == 3) {%>
		<li>회원등급 : 준회원</li>
		<%} %>
		<li>가입일 : <%=m.getEnrollDate() %></li>
	</ul>
	<%} %>
</body>
</html>