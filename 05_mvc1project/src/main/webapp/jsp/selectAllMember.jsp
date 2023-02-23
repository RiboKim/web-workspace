<%@page import="kr.or.iei.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.iei.model.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    //1.인코딩
    request.setCharacterEncoding("utf-8");
    //2.값추출
    //3.비즈니스로직
    MemberService service = new MemberService();
    ArrayList<Member> list = service.selectAllMember();
    //4.결과처리
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if(list.size() == 0){%>
		<h2>회원정보를 조회할 수 없습니다.</h2>
	<%}else{%>
		<h1>전체 회원 정보</h1>
		<hr>
		<table border ="1">
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
		
		<%for(Member m : list) {%>
			<tr>
			<td><%=m.getMemberNo() %></td>
			<td><%=m.getMemberId() %></td>
			<td><%=m.getMemberPw() %></td>
			<td><%=m.getMemberName() %></td>
			<td><%=m.getMemberPhone() %></td>
			<td><%=m.getMemberAddr() %></td>
			<%if (m.getMemberLevel() == 1){ %>
			<td>관리자</td>
			<%}else if(m.getMemberLevel() == 2){ %>
			<td>정회원</td>
			<%}else{ %>
			<td>준회원</td>
			<%} %>
			<td><%=m.getEnrollDate() %></td>
			</tr>
			<%} %>
		</table>
		<%} %>
</body>
</html>