<%@page import="kr.or.iei.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   //servlet이 보내준 파일을 꺼내주는 작업
   //servlet이 보내주는 데이터는 형태가 다양하기에 항상 Object
   //따라서 사용하고 싶은 객체 타입으로 DownCasting(형변환)해주어야함
   //자동 auto boxing 덕분에 이렇게 쓸 수 있는거임 정석은 아래 주석
   int result = (int)request.getAttribute("result");
  
   /*
   Integer num = (Integer)request.getAttribute("result");
   int result = num.intValue();
   */
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(result>0){ %>
	<h2>회원가입에 성공했습니다.</h2>
	<%}else{ %>
	<h2>회원가입에 실패했습니다.</h2>
	<%} %>
</body>
</html>