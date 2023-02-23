<%@page import="kr.or.iei.model.service.MemberService"%>
<%@page import="kr.or.iei.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //1.인코딩
    request.setCharacterEncoding("utf-8");
    //2.값추출
   	/*
    Member m = new Member();
   	m.setMemberId(request.getParameter("memberId"));
	m.setMemberPw(request.getParameter("memberPw"));
	m.setMemberName(request.getParameter("memberName"));
	m.setMemberAddr(request.getParameter("memberAddr"));
	m.setMemberPhone(request.getParameter("memberPhone"));
    */
    
    String memberId = request.getParameter("memberId");
    String memberPw = request.getParameter("memberPw");
    String memberName = request.getParameter("memberName");
    String memberAddr = request.getParameter("memberAddr");
    String memberPhone = request.getParameter("memberPhone");
    Member m = new Member(memberId, memberPw, memberName, memberAddr, memberPhone);
    
    //3.비즈니스로직
    
    MemberService service = new MemberService();
    int result = service.joinMember(m);
    
	//4.결과처리   
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(result>0){ %>
	<h1>회원가입에 성공했습니다.</h1>
	<%}else{ %>
	<h1>회원가입에 실패했습니다.</h1>
	<%} %>
</body>
</html>