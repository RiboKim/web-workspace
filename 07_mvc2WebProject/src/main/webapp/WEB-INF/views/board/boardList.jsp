<%@page import="kr.or.iei.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
    String pageNavi = (String)request.getAttribute("pageNavi");
    int start = (int)request.getAttribute("start");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.board-tbl a:hover{
		text-decoration: underline;
	}
	.board-tbl tr{
		border-bottom: 1px solid #ccc;
	}
	.board-tbl tr>td:nth-child(2) {
		text-align: left;
	}
	#pageNavi{
		margin 30px;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="content-title">자유게시판</div>
		<%if(m != null && m.getMemberLevel() != 3) {%>
		<a class="btn bc4 writeBtn" href="/boardWriteFrm.do">글쓰기</a>
		<%} %>
		
		<table class="tbl tbl-hover board-tbl">
			<tr class="tr-2">
				<th style="width10%">번호</th>
				<th style="width45%">제목</th>
				<th style="width15%">작성자</th>
				<th style="width20%">작성일</th>
				<th style="width10%">조회수</th>
			</tr>
			<%for(int i=0;i<list.size();i++) {%>
				<%Board b = list.get(i); %>
			<tr class="tr-1">
				<td><%=i+start %></td>
				<td>
					<a href="/boardView.do?boardNo=<%=b.getBoardNo() %>">
						<%=b.getBoardTitle() %>
					</a>
				</td>
				<td><%=b.getBoardWriter() %></td>
				<td><%=b.getRegDate() %></td>
				<td><%=b.getReadCount() %></td>
				
			</tr>
			<%} %>
		</table>
		<div id="pageNavi"><%=pageNavi %></div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>