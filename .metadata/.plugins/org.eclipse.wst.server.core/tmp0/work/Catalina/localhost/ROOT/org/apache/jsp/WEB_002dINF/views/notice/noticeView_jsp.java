/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.85
 * Generated at: 2023-02-21 10:07:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kr.or.iei.notice.model.vo.NoticeComment;
import java.util.ArrayList;
import kr.or.iei.notice.model.vo.Notice;
import kr.or.iei.member.model.vo.Member;

public final class noticeView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1676958928861L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1676337261927L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("kr.or.iei.notice.model.vo.NoticeComment");
    _jspx_imports_classes.add("kr.or.iei.notice.model.vo.Notice");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("kr.or.iei.member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");

    Notice n = (Notice)request.getAttribute("n");
    ArrayList<NoticeComment> commentList = (ArrayList<NoticeComment>)request.getAttribute("commentList");
    ArrayList<NoticeComment> reCommentList = (ArrayList<NoticeComment>)request.getAttribute("reCommentList");
    
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("	#noticeView th, #noticeView td{\r\n");
      out.write("		border : 1px solid #eee;\r\n");
      out.write("	}\r\n");
      out.write("	#noticeContent{\r\n");
      out.write("		text-align: left;\r\n");
      out.write("		min-height: 300px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.inputCommentBox{\r\n");
      out.write("		margin : 50px;\r\n");
      out.write("	}\r\n");
      out.write("	.inputCommentBox>form>ul{\r\n");
      out.write("		list-style-type: none;\r\n");
      out.write("		display: flex;\r\n");
      out.write("	}\r\n");
      out.write("	.inputCommentBox>form>uyl>li:first-child{\r\n");
      out.write("		width: 15%;\r\n");
      out.write("		display: flex;\r\n");
      out.write("		justify-content: center;\r\n");
      out.write("		align-items: center;\r\n");
      out.write("	}\r\n");
      out.write("	.inputCommentBox>form>ul>li:first-child>span{\r\n");
      out.write("		font-size: 80px;\r\n");
      out.write("		color: #ccc;\r\n");
      out.write("	}\r\n");
      out.write("	.inputCommentBox>form>ul>li:nth-child(2){\r\n");
      out.write("		width: 75%;\r\n");
      out.write("	}\r\n");
      out.write("	.inputCommentBox>form>ul>li:nth-child(2)>textarea{\r\n");
      out.write("		height: 96px;\r\n");
      out.write("		min-height: 96px;\r\n");
      out.write("	}\r\n");
      out.write("	.inputCommentBox>form>ul>li:last-child{\r\n");
      out.write("		width: 10%;\r\n");
      out.write("	}\r\n");
      out.write("	.commentBox{\r\n");
      out.write("		margin: 50px;\r\n");
      out.write("	}\r\n");
      out.write("	.inputRecommentBox{\r\n");
      out.write("		margin: 30px 0px;\r\n");
      out.write("		display: none;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");

    	Member m = (Member)session.getAttribute("m");
    
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<!-- 구글 아이콘 -->\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- jquery -->\r\n");
      out.write("    <script src=\"/js/jquery-3.6.0.js\"></script>\r\n");
      out.write("    <!-- 기본 CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/default.css\" />\r\n");
      out.write("    <!-- 기본 js -->\r\n");
      out.write("    <script src=\"/js/default.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <header>\r\n");
      out.write("      <div class=\"site-logo\">\r\n");
      out.write("        <a href=\"/\">GOLD KIWI</a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <nav>\r\n");
      out.write("        <ul class=\"navi\">\r\n");
      out.write("          <li><a href=\"/noticeList.do?requestPage=1\">공지사항</a></li>\r\n");
      out.write("          <li><a href=\"/boardList.do\">자유게시판</a></li>\r\n");
      out.write("          <li><a href=\"/ajax.do\">AJAX</a></li>\r\n");
      out.write("          <li><a href=\"/photoList.do\">사진게시판</a></li>\r\n");
      out.write("          <li>\r\n");
      out.write("			<a href=\"#\">메뉴-5</a>\r\n");
      out.write("            <ul class=\"sub-navi\">\r\n");
      out.write("              <li><a href=\"#\">sub-1</a></li>\r\n");
      out.write("              <li><a href=\"#\">sub-2</a></li>\r\n");
      out.write("              <li><a href=\"#\">sub-3</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("           </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </nav>\r\n");
      out.write("      <div class=\"header-link\">\r\n");
      out.write("      ");
if(m == null){ 
      out.write("\r\n");
      out.write("        <button class=\"btn bc11 modal-open-btn\" target=\"#login-modal\">SIGN IN</button>\r\n");
      out.write("        <a class=\"btn bc11\" href=\"/signupFrm.do\">SIGN UP</a>\r\n");
      out.write("      ");
}else{ 
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("      <a class=\"btn bc11\" href=\"/mypage2.do?memberId=");
      out.print(m.getMemberId() );
      out.write('"');
      out.write('>');
      out.print(m.getMemberName() );
      out.write("</a>\r\n");
      out.write("      \r\n");
      out.write("      <a class=\"btn bc11\" href=\"/logout.do\">LOGOUT</a>\r\n");
      out.write("      ");
} 
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </header>\r\n");
      out.write("    ");
if(m == null) {
      out.write("\r\n");
      out.write("    <div id=\"login-modal\" class=\"modal-bg\">\r\n");
      out.write("      <div class=\"modal-wrap\">\r\n");
      out.write("        <div class=\"modal-head\">\r\n");
      out.write("          <h2>SIGN IN</h2>\r\n");
      out.write("          <span class=\"material-icons close-icon modal-close\">close</span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <form action=\"/signin.do\" method=\"post\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("          <div class=\"input-box\">\r\n");
      out.write("          	<label for=\"signId\">아이디</label>\r\n");
      out.write("          	<input type=\"text\" name=\"signId\" id=\"signId\" class=\"input-form\" placeholder=\"아이디입력\">\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"input-box\">\r\n");
      out.write("          	<label for=\"signPw\">비밀번호</label>\r\n");
      out.write("          	<input type=\"password\" name=\"signPw\" id=\"signPw\" class=\"input-form\" placeholder=\"비밀번호입력\">\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"input-box link-box\">\r\n");
      out.write("          	<a href=\"#\">아이디/비밀번호 찾기</a>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"modal-foot\">\r\n");
      out.write("          <button type=\"submit\" class=\"btn bc11\">로그인</button>\r\n");
      out.write("          <button type=\"button\" class=\"btn bc1 modal-close\">취소</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        </form>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");
}
      out.write("\r\n");
      out.write("	<div class=\"page-content\">\r\n");
      out.write("		<div class=\"page-title\">공지사항</div>\r\n");
      out.write("		<table class=\"tbl\" id=\"noticeView\">\r\n");
      out.write("			<tr class=\"tr-3\">\r\n");
      out.write("				<th colspan=\"6\">");
      out.print(n.getNoticeTitle() );
      out.write("</th>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr class=\"tr-1\">\r\n");
      out.write("				<th class=\"td-3\">작성자</th>\r\n");
      out.write("				<td>");
      out.print(n.getNoticeWriter() );
      out.write("</td>\r\n");
      out.write("				<th class=\"td-3\">작성일</th>\r\n");
      out.write("				<td>");
      out.print(n.getRegDate() );
      out.write("</td>\r\n");
      out.write("				<th class=\"td-3\">조회수</th>\r\n");
      out.write("				<td>");
      out.print(n.getReadCount() );
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr class=\"tr-1\">\r\n");
      out.write("				<th class=\"td-3\">첨부파일</th>\r\n");
      out.write("				<td colspan=\"5\">\r\n");
      out.write("				");
if(n.getFilename() != null){ 
      out.write("\r\n");
      out.write("				<img src=\"/img/file.png\" width=\"16px\">\r\n");
      out.write("				<a href=\"/noticeFileDown.do?noticeNo=");
      out.print(n.getNoticeNo() );
      out.write('"');
      out.write('>');
      out.print(n.getFilename() );
      out.write("</a>\r\n");
      out.write("				");
} 
      out.write("\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr class=\"tr-1\">\r\n");
      out.write("				<td colspan=\"6\">\r\n");
      out.write("					<div id=\"noticeContent\">\r\n");
      out.write("						");
      out.print(n.getNoticeContentBr() );
      out.write("\r\n");
      out.write("					</div>\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr><!-- 로그인이 되어있는 상태에서 아이디랑 작성자 같은지  -->\r\n");
      out.write("				");
if(m!=null && m.getMemberId().equals(n.getNoticeWriter())) {
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th colspan=\"6\">\r\n");
      out.write("						<a class=\"btn bc44\" href=\"/noticeUpdateFrm.do?noticeNo=");
      out.print(n.getNoticeNo() );
      out.write("\">수정</a>\r\n");
      out.write("						<button class=\"btn bc44\" onclick=\"noticeDelete(");
      out.print(n.getNoticeNo());
      out.write(");\">삭제</button>\r\n");
      out.write("					</th>\r\n");
      out.write("				</tr>\r\n");
      out.write("				");
} 
      out.write("\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"commentBox\">\r\n");
      out.write("         ");
for(NoticeComment nc : commentList){ 
      out.write("\r\n");
      out.write("            <ul class=\"posting-comment\">\r\n");
      out.write("               <li>\r\n");
      out.write("                  <span class=\"material-icons\">account_box</span>\r\n");
      out.write("               </li>\r\n");
      out.write("               <li>\r\n");
      out.write("                  <p class=\"comment-info\">\r\n");
      out.write("                     <span>");
      out.print(nc.getNcWriter() );
      out.write("</span>\r\n");
      out.write("                     <span>");
      out.print(nc.getNcDate() );
      out.write("</span>\r\n");
      out.write("                  </p>\r\n");
      out.write("                  <p class=\"comment-content\">\r\n");
      out.write("                     ");
      out.print(nc.getNcContentBr() );
      out.write("\r\n");
      out.write("                  </p>\r\n");
      out.write("                  <textarea name=\"ncContent\" class=\"input-form\" style=\"min-height: 96px; display: none;\">");
      out.print(nc.getNcContentBr() );
      out.write("</textarea>\r\n");
      out.write("                  <p class=\"comment-link\">\r\n");
      out.write("                     ");
if(m != null){ 
      out.write(" <!-- 만약 로그인이 되어있으면 -->\r\n");
      out.write("                        ");
if(m.getMemberId().equals(nc.getNcWriter())){ 
      out.write("<!-- 로그인한 회원 아이디와 댓글 작성자가 같으면 -->\r\n");
      out.write("                          	<a href=\"javascript:void(0)\" onclick=\"modifyComment(this,");
      out.print(nc.getNcNo());
      out.write(',');
      out.print(n.getNoticeNo());
      out.write(");\">수정</a>\r\n");
      out.write("            				<a href=\"javascript:void(0)\" onclick=\"deleteComment(this,");
      out.print(nc.getNcNo());
      out.write(',');
      out.print(n.getNoticeNo());
      out.write(");\">삭제</a>\r\n");
      out.write("                        ");
} //해당 댓글 수정 조건(댓글작성자==로그인회원)
      out.write("\r\n");
      out.write("                        <a href=\"javascript:void(0)\" class=\"recShow\">답글달기</a>\r\n");
      out.write("                     ");
}//대댓글 달기 조건문(로그인회원)
      out.write("\r\n");
      out.write("                  </p>\r\n");
      out.write("               </li>            \r\n");
      out.write("            </ul>\r\n");
      out.write("            ");
for(NoticeComment ncc : reCommentList) {
      out.write("\r\n");
      out.write("            	");
if(ncc.getNcRef() == nc.getNcNo()) {
      out.write("\r\n");
      out.write("            	<ul class=\"posting-comment reply\">\r\n");
      out.write("            		<li>\r\n");
      out.write("            			<span class=\"material-icons\">subdirectory_arrow_right</span>\r\n");
      out.write("            			<span class=\"material-icons\">account_box</span>\r\n");
      out.write("            		</li>\r\n");
      out.write("            		<li>\r\n");
      out.write("            			<p class=\"comment-info\">\r\n");
      out.write("            				<span>");
      out.print(ncc.getNcWriter() );
      out.write("</span>\r\n");
      out.write("            				<span>");
      out.print(ncc.getNcDate() );
      out.write("</span>\r\n");
      out.write("            			</p>\r\n");
      out.write("            			<p class=\"comment-content\">");
      out.print(ncc.getNcContentBr() /*엔터먹게 하려고 vo에 NcContentBr을 따로 추가했음*/);
      out.write("</p>\r\n");
      out.write("            			<textarea name=\"ncContent\" class=\"input-form\" style=\"min-height: 96px; display: none;\">");
      out.print(ncc.getNcContentBr() );
      out.write("</textarea>\r\n");
      out.write("            			<p class=\"comment-link\">\r\n");
      out.write("            				");
if(m != null && m.getMemberId().equals(ncc.getNcWriter())) {
      out.write("\r\n");
      out.write("            					<a href=\"javascript:void(0)\" onclick=\"modifyComment(this,");
      out.print(ncc.getNcNo());
      out.write(',');
      out.print(n.getNoticeNo());
      out.write(");\">수정</a>\r\n");
      out.write("            					<a href=\"javascript:void(0)\" onclick=\"deleteComment(this,");
      out.print(ncc.getNcNo());
      out.write(',');
      out.print(n.getNoticeNo());
      out.write(");\">삭제</a>\r\n");
      out.write("            				");
} 
      out.write("\r\n");
      out.write("            			</p>\r\n");
      out.write("            		</li>\r\n");
      out.write("            	</ul>\r\n");
      out.write("           	 	");
}//대댓글 출력 if문 
      out.write("\r\n");
      out.write("            ");
}//대댓글 출력 for문 
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
if(m != null){ 
      out.write("\r\n");
      out.write("            \r\n");
      out.write("               <div class=\"inputRecommentBox inputCommentBox\">\r\n");
      out.write("                  <form action=\"/insertNoticeComment.do\" method=\"post\">\r\n");
      out.write("                     <ul>\r\n");
      out.write("                        <li>\r\n");
      out.write("                           <span class=\"material-icons\">subdirectory_arrow_right</span>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                           <input type=\"hidden\" name=\"ncWriter\" value=\"");
      out.print(m.getMemberId());
      out.write("\">\r\n");
      out.write("                           <input type=\"hidden\" name=\"noticeRef\" value=\"");
      out.print(n.getNoticeNo());
      out.write("\">\r\n");
      out.write("                           <input type=\"hidden\" name=\"ncRef\" value=\"");
      out.print(nc.getNcNo());
      out.write("\">\r\n");
      out.write("                           <textarea name=\"ncContent\" class=\"input-form\"></textarea>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                           <button type=\"submit\" class=\"btn bc1 bs4\">등록</button>\r\n");
      out.write("                        </li>\r\n");
      out.write("                     </ul>\r\n");
      out.write("                  </form>\r\n");
      out.write("               </div>\r\n");
      out.write("            \r\n");
      out.write("            ");
} 
      out.write("\r\n");
      out.write("            \r\n");
      out.write("         ");
} //댓글 출력 for문 끝
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("      <!-- 로그인 되어있는 경우에만 댓글 작성 화면을 띄움 -->\r\n");
      out.write("      ");
if(m != null){ 
      out.write("\r\n");
      out.write("         <div class=\"inputCommentBox\">\r\n");
      out.write("            <form action=\"/insertNoticeComment.do\" method=\"post\">\r\n");
      out.write("               <ul>\r\n");
      out.write("                  <li>\r\n");
      out.write("                     <span class=\"material-icons\">account_box</span>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li>\r\n");
      out.write("                     <input type=\"hidden\" name=\"ncWriter\" value=\"");
      out.print(m.getMemberId() );
      out.write("\">\r\n");
      out.write("                     <input type=\"hidden\" name=\"noticeRef\" value=\"");
      out.print(n.getNoticeNo());
      out.write("\"> <!-- 댓글이 어떤 공지사항에 달렸는지 -->\r\n");
      out.write("                     <input type=\"hidden\" name=\"ncRef\" value=\"0\"> <!-- 대댓글이 어떤 댓글 아래에 달렸는지 -->\r\n");
      out.write("                     <textarea name=\"ncContent\" class=\"input-form\"></textarea>\r\n");
      out.write("                  </li>\r\n");
      out.write("                  <li>\r\n");
      out.write("                     <button type=\"submit\" class=\"btn bc1 bs4\">등록</button>\r\n");
      out.write("                  </li>\r\n");
      out.write("               </ul>\r\n");
      out.write("            </form>\r\n");
      out.write("         </div>\r\n");
      out.write("      ");
} 
      out.write("\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		<script>\r\n");
      out.write("			function noticeDelete(noticeNo){\r\n");
      out.write("				if(confirm(\"게시글을 삭제하시겠습니까?\")){\r\n");
      out.write("					location.href=\"/deleteNotice.do?noticeNo=\"+noticeNo;\r\n");
      out.write("					console.log(\"삭제해줘\");\r\n");
      out.write("				}\r\n");
      out.write("			}\r\n");
      out.write("			$(\".recShow\").on(\"click\",function(){\r\n");
      out.write("				//몇번째 답글달기 버튼을 클릭한지\r\n");
      out.write("				const idx = $(\".recShow\").index(this);\r\n");
      out.write("				if($(this).text() == \"답글달기\"){\r\n");
      out.write("					$(this).text(\"취소\");\r\n");
      out.write("				}else{\r\n");
      out.write("					$(this).text(\"답글달기\");\r\n");
      out.write("				}\r\n");
      out.write("				$(\".inputRecommentBox\").eq(idx).toggle();\r\n");
      out.write("				$(\".inputRecommentBox\").eq(idx).find(\"textarea\").focus();\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			function modifyComment(obj, ncNo, noticeNo){\r\n");
      out.write("				//숨겨놓은 textarea를 화면에 보여줌\r\n");
      out.write("				$(obj).parent().prev().show();\r\n");
      out.write("				//화면에 있던 댓글내용)(p태그)를 숨김\r\n");
      out.write("				$(obj).parent().prev().prev().hide();\r\n");
      out.write("            	//수정 -> 수정완료\r\n");
      out.write("            	$(obj).text(\"수정완료\");\r\n");
      out.write("            	$(obj).attr(\"onclick\",\"modifyComplete(this,\"+ncNo+\",\"+noticeNo+\")\");\r\n");
      out.write("            	//삭제 -> 수정취소(원래 상태로 되돌리겠다)\r\n");
      out.write("            	$(obj).next().text(\"수정취소\");\r\n");
      out.write("            	$(obj).next().attr(\"onclick\",\"modifyCancel(this,\"+ncNo+\",\"+noticeNo+\")\");\r\n");
      out.write("            	//답글달기버튼 삭제\r\n");
      out.write("            	$(obj).next().next().hide();\r\n");
      out.write("			}\r\n");
      out.write("			function modifyCancel(obj,ncNo,noticeNo){\r\n");
      out.write("				$(obj).parent().prev().hide();//textarea숨김\r\n");
      out.write("				$(obj).parent().prev().prev().show();//기존댓글 다시 보여줌\r\n");
      out.write("				//수정완료 -> 수정\r\n");
      out.write("				$(obj).prev().text(\"수정\");\r\n");
      out.write("				$(obj).prev().attr(\"onclick\",\"modifyComment(this,\"+ncNo+\",\"+noticeNo+\")\");\r\n");
      out.write("				//수정취소 -> 삭제\r\n");
      out.write("				$(obj).text(\"삭제\");\r\n");
      out.write("				$(obj).attr(\"onclick\",\"deleteComment(this,\"+ncNo+\",\"+noticeNo+\")\");\r\n");
      out.write("				//답글달기 버튼 다시 보여줘야함\r\n");
      out.write("				$(obj).next().show();\r\n");
      out.write("			}\r\n");
      out.write("			function modifyComplete(obj, ncNo,noticeNo){\r\n");
      out.write("				//form태그를 생성해서 전송\r\n");
      out.write("				//댓글내용, 댓글번호,공지사항번호\r\n");
      out.write("				//1.form태그 생성\r\n");
      out.write("				const form = $(\"<form style='display:none;' action='/updateNoticeComment.do' method='post'></form>\");\r\n");
      out.write("				//2.input태그2개 숨김\r\n");
      out.write("				const ncNoInput = $(\"<input type='text' name='ncNo'>\");\r\n");
      out.write("				ncNoInput.val(ncNo);\r\n");
      out.write("				const noticeNoInput = $(\"<input type='text' name='noticeNo'>\");\r\n");
      out.write("				noticeNoInput.val(noticeNo);\r\n");
      out.write("				//3.textarea(textarea가 사라진 느낌이 안 들게 clone()으로 복사해서 사용)\r\n");
      out.write("				const ncContent = $(obj).parent().prev().clone();\r\n");
      out.write("				//4.form태그에 input, textarea를 모두 포함\r\n");
      out.write("				form.append(ncNoInput).append(noticeNoInput).append(ncContent);\r\n");
      out.write("				//5.생성된 form태그를 body태그에 추가\r\n");
      out.write("				$(\"body\").append(form);\r\n");
      out.write("				//form태그를 전송\r\n");
      out.write("				form.submit();\r\n");
      out.write("			}\r\n");
      out.write("			function deleteComment(obj,ncNo,noticeNo){\r\n");
      out.write("				if(confirm(\"댓글을 삭제하시겠습니까?\")){\r\n");
      out.write("					location.href=\"/deleteNoticeComment.do?ncNo=\"+ncNo+\"&noticeNo=\"+noticeNo;\r\n");
      out.write("				}\r\n");
      out.write("			}\r\n");
      out.write("		</script>\r\n");
      out.write("	</div>\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("	<footer>\r\n");
      out.write("      <div class=\"footer-content\">\r\n");
      out.write("        <ul>\r\n");
      out.write("          <li><a href=\"#\">이용약관</a></li>\r\n");
      out.write("          <li><a href=\"#\">개인정보취급방침</a></li>\r\n");
      out.write("          <li><a href=\"#\">인재채용</a></li>\r\n");
      out.write("          <li><a href=\"#\">제휴문의</a></li>\r\n");
      out.write("          <li><a href=\"#\">인스타그램</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <p>Made by LeeYunSu</p>\r\n");
      out.write("        <p>\r\n");
      out.write("          KH정보교육원 당산지원 A강의장 수업자료입니다. 무단복제를 허용하지\r\n");
      out.write("          않습니다.\r\n");
      out.write("        </p>\r\n");
      out.write("      </div>\r\n");
      out.write("    </footer>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}