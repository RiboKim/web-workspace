<%@page import="kr.or.iei.notice.model.vo.NoticeComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.iei.notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Notice n = (Notice)request.getAttribute("n");
    ArrayList<NoticeComment> commentList = (ArrayList<NoticeComment>)request.getAttribute("commentList");
    ArrayList<NoticeComment> reCommentList = (ArrayList<NoticeComment>)request.getAttribute("reCommentList");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#noticeView th, #noticeView td{
		border : 1px solid #eee;
	}
	#noticeContent{
		text-align: left;
		min-height: 300px;
	}
	
	.inputCommentBox{
		margin : 50px;
	}
	.inputCommentBox>form>ul{
		list-style-type: none;
		display: flex;
	}
	.inputCommentBox>form>uyl>li:first-child{
		width: 15%;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.inputCommentBox>form>ul>li:first-child>span{
		font-size: 80px;
		color: #ccc;
	}
	.inputCommentBox>form>ul>li:nth-child(2){
		width: 75%;
	}
	.inputCommentBox>form>ul>li:nth-child(2)>textarea{
		height: 96px;
		min-height: 96px;
	}
	.inputCommentBox>form>ul>li:last-child{
		width: 10%;
	}
	.commentBox{
		margin: 50px;
	}
	.inputRecommentBox{
		margin: 30px 0px;
		display: none;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">공지사항</div>
		<table class="tbl" id="noticeView">
			<tr class="tr-3">
				<th colspan="6"><%=n.getNoticeTitle() %></th>
			</tr>
			<tr class="tr-1">
				<th class="td-3">작성자</th>
				<td><%=n.getNoticeWriter() %></td>
				<th class="td-3">작성일</th>
				<td><%=n.getRegDate() %></td>
				<th class="td-3">조회수</th>
				<td><%=n.getReadCount() %></td>
			</tr>
			<tr class="tr-1">
				<th class="td-3">첨부파일</th>
				<td colspan="5">
				<%if(n.getFilename() != null){ %>
				<img src="/img/file.png" width="16px">
				<a href="/noticeFileDown.do?noticeNo=<%=n.getNoticeNo() %>"><%=n.getFilename() %></a>
				<%} %>
				</td>
			</tr>
			<tr class="tr-1">
				<td colspan="6">
					<div id="noticeContent">
						<%=n.getNoticeContentBr() %>
					</div>
				</td>
			</tr>
			<tr><!-- 로그인이 되어있는 상태에서 아이디랑 작성자 같은지  -->
				<%if(m!=null && m.getMemberId().equals(n.getNoticeWriter())) {%>
				<tr>
					<th colspan="6">
						<a class="btn bc44" href="/noticeUpdateFrm.do?noticeNo=<%=n.getNoticeNo() %>">수정</a>
						<button class="btn bc44" onclick="noticeDelete(<%=n.getNoticeNo()%>);">삭제</button>
					</th>
				</tr>
				<%} %>
			</tr>
		</table>
		
		<div class="commentBox">
         <%for(NoticeComment nc : commentList){ %>
            <ul class="posting-comment">
               <li>
                  <span class="material-icons">account_box</span>
               </li>
               <li>
                  <p class="comment-info">
                     <span><%=nc.getNcWriter() %></span>
                     <span><%=nc.getNcDate() %></span>
                  </p>
                  <p class="comment-content">
                     <%=nc.getNcContentBr() %>
                  </p>
                  <textarea name="ncContent" class="input-form" style="min-height: 96px; display: none;"><%=nc.getNcContentBr() %></textarea>
                  <p class="comment-link">
                     <%if(m != null){ %> <!-- 만약 로그인이 되어있으면 -->
                        <%if(m.getMemberId().equals(nc.getNcWriter())){ %><!-- 로그인한 회원 아이디와 댓글 작성자가 같으면 -->
                          	<a href="javascript:void(0)" onclick="modifyComment(this,<%=nc.getNcNo()%>,<%=n.getNoticeNo()%>);">수정</a>
            				<a href="javascript:void(0)" onclick="deleteComment(this,<%=nc.getNcNo()%>,<%=n.getNoticeNo()%>);">삭제</a>
                        <%} //해당 댓글 수정 조건(댓글작성자==로그인회원)%>
                        <a href="javascript:void(0)" class="recShow">답글달기</a>
                     <%}//대댓글 달기 조건문(로그인회원)%>
                  </p>
               </li>            
            </ul>
            <%for(NoticeComment ncc : reCommentList) {%>
            	<%if(ncc.getNcRef() == nc.getNcNo()) {%>
            	<ul class="posting-comment reply">
            		<li>
            			<span class="material-icons">subdirectory_arrow_right</span>
            			<span class="material-icons">account_box</span>
            		</li>
            		<li>
            			<p class="comment-info">
            				<span><%=ncc.getNcWriter() %></span>
            				<span><%=ncc.getNcDate() %></span>
            			</p>
            			<p class="comment-content"><%=ncc.getNcContentBr() /*엔터먹게 하려고 vo에 NcContentBr을 따로 추가했음*/%></p>
            			<textarea name="ncContent" class="input-form" style="min-height: 96px; display: none;"><%=ncc.getNcContentBr() %></textarea>
            			<p class="comment-link">
            				<%if(m != null && m.getMemberId().equals(ncc.getNcWriter())) {%>
            					<a href="javascript:void(0)" onclick="modifyComment(this,<%=ncc.getNcNo()%>,<%=n.getNoticeNo()%>);">수정</a>
            					<a href="javascript:void(0)" onclick="deleteComment(this,<%=ncc.getNcNo()%>,<%=n.getNoticeNo()%>);">삭제</a>
            				<%} %>
            			</p>
            		</li>
            	</ul>
           	 	<%}//대댓글 출력 if문 %>
            <%}//대댓글 출력 for문 %>
            <%--댓글에 대한 대댓글 입력양식(당연히 로그인 된 상태여야 함) --%>
            <%if(m != null){ %>
            
               <div class="inputRecommentBox inputCommentBox">
                  <form action="/insertNoticeComment.do" method="post">
                     <ul>
                        <li>
                           <span class="material-icons">subdirectory_arrow_right</span>
                        </li>
                        <li>
                           <input type="hidden" name="ncWriter" value="<%=m.getMemberId()%>">
                           <input type="hidden" name="noticeRef" value="<%=n.getNoticeNo()%>">
                           <input type="hidden" name="ncRef" value="<%=nc.getNcNo()%>">
                           <textarea name="ncContent" class="input-form"></textarea>
                        </li>
                        <li>
                           <button type="submit" class="btn bc1 bs4">등록</button>
                        </li>
                     </ul>
                  </form>
               </div>
            
            <%} %>
            
         <%} //댓글 출력 for문 끝%>
      </div>
      
      <!-- 로그인 되어있는 경우에만 댓글 작성 화면을 띄움 -->
      <%if(m != null){ %>
         <div class="inputCommentBox">
            <form action="/insertNoticeComment.do" method="post">
               <ul>
                  <li>
                     <span class="material-icons">account_box</span>
                  </li>
                  <li>
                     <input type="hidden" name="ncWriter" value="<%=m.getMemberId() %>">
                     <input type="hidden" name="noticeRef" value="<%=n.getNoticeNo()%>"> <!-- 댓글이 어떤 공지사항에 달렸는지 -->
                     <input type="hidden" name="ncRef" value="0"> <!-- 대댓글이 어떤 댓글 아래에 달렸는지 -->
                     <textarea name="ncContent" class="input-form"></textarea>
                  </li>
                  <li>
                     <button type="submit" class="btn bc1 bs4">등록</button>
                  </li>
               </ul>
            </form>
         </div>
      <%} %>
		
		
		<script>
			function noticeDelete(noticeNo){
				if(confirm("게시글을 삭제하시겠습니까?")){
					location.href="/deleteNotice.do?noticeNo="+noticeNo;
					console.log("삭제해줘");
				}
			}
			$(".recShow").on("click",function(){
				//몇번째 답글달기 버튼을 클릭한지
				const idx = $(".recShow").index(this);
				if($(this).text() == "답글달기"){
					$(this).text("취소");
				}else{
					$(this).text("답글달기");
				}
				$(".inputRecommentBox").eq(idx).toggle();
				$(".inputRecommentBox").eq(idx).find("textarea").focus();
			});
			
			function modifyComment(obj, ncNo, noticeNo){
				//숨겨놓은 textarea를 화면에 보여줌
				$(obj).parent().prev().show();
				//화면에 있던 댓글내용)(p태그)를 숨김
				$(obj).parent().prev().prev().hide();
            	//수정 -> 수정완료
            	$(obj).text("수정완료");
            	$(obj).attr("onclick","modifyComplete(this,"+ncNo+","+noticeNo+")");
            	//삭제 -> 수정취소(원래 상태로 되돌리겠다)
            	$(obj).next().text("수정취소");
            	$(obj).next().attr("onclick","modifyCancel(this,"+ncNo+","+noticeNo+")");
            	//답글달기버튼 삭제
            	$(obj).next().next().hide();
			}
			function modifyCancel(obj,ncNo,noticeNo){
				$(obj).parent().prev().hide();//textarea숨김
				$(obj).parent().prev().prev().show();//기존댓글 다시 보여줌
				//수정완료 -> 수정
				$(obj).prev().text("수정");
				$(obj).prev().attr("onclick","modifyComment(this,"+ncNo+","+noticeNo+")");
				//수정취소 -> 삭제
				$(obj).text("삭제");
				$(obj).attr("onclick","deleteComment(this,"+ncNo+","+noticeNo+")");
				//답글달기 버튼 다시 보여줘야함
				$(obj).next().show();
			}
			function modifyComplete(obj, ncNo,noticeNo){
				//form태그를 생성해서 전송
				//댓글내용, 댓글번호,공지사항번호
				//1.form태그 생성
				const form = $("<form style='display:none;' action='/updateNoticeComment.do' method='post'></form>");
				//2.input태그2개 숨김
				const ncNoInput = $("<input type='text' name='ncNo'>");
				ncNoInput.val(ncNo);
				const noticeNoInput = $("<input type='text' name='noticeNo'>");
				noticeNoInput.val(noticeNo);
				//3.textarea(textarea가 사라진 느낌이 안 들게 clone()으로 복사해서 사용)
				const ncContent = $(obj).parent().prev().clone();
				//4.form태그에 input, textarea를 모두 포함
				form.append(ncNoInput).append(noticeNoInput).append(ncContent);
				//5.생성된 form태그를 body태그에 추가
				$("body").append(form);
				//form태그를 전송
				form.submit();
			}
			function deleteComment(obj,ncNo,noticeNo){
				if(confirm("댓글을 삭제하시겠습니까?")){
					location.href="/deleteNoticeComment.do?ncNo="+ncNo+"&noticeNo="+noticeNo;
				}
			}
		</script>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>