/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.85
 * Generated at: 2023-02-17 09:00:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kr.or.iei.notice.model.vo.Notice;
import kr.or.iei.member.model.vo.Member;

public final class noticeUpdateFrm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1676596454984L));
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
    _jspx_imports_classes.add("kr.or.iei.notice.model.vo.Notice");
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
      out.write("    ");

    Notice n = (Notice)request.getAttribute("n");
    
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
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
      out.write("          <li><a href=\"#\">메뉴-3</a></li>\r\n");
      out.write("          <li><a href=\"#\">메뉴-4</a></li>\r\n");
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
      out.write("		<div class=\"page-title\">공지사항수정</div>\r\n");
      out.write("		<form action=\"/noticeUpdate.do\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("			<table class=\"tbl\" id=\"noticeUpdateFrm\">\r\n");
      out.write("				<tr class=\"tr-1\">\r\n");
      out.write("					<th class=\"td-3\">제목</th>\r\n");
      out.write("					<td>\r\n");
      out.write("						<input type=\"text\" name=\"noticeTitle\" class=\"input-form\" value=\"");
      out.print(n.getNoticeTitle());
      out.write("\">\r\n");
      out.write("						<input type=\"hidden\" name=\"status\" value=\"stay\">\r\n");
      out.write("						<input type=\"hidden\" name=\"noticeNo\" value=\"");
      out.print(n.getNoticeNo());
      out.write("\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr class=\"tr-1\">\r\n");
      out.write("					<th class=\"td-3\">첨부파일</th>\r\n");
      out.write("					<td>\r\n");
      out.write("						");
if(n.getFilepath() != null) {
      out.write("\r\n");
      out.write("							<img src=\"/img/file.png\" width=\"16px\" class=\"delFile\">\r\n");
      out.write("							<span class=\"delFile\">");
      out.print(n.getFilename() );
      out.write("</span>\r\n");
      out.write("							<button type=\"button\" class=\"btn bc1 delFile\">삭제</button>\r\n");
      out.write("							<input type=\"file\" name=\"upfile\" style=\"display:none;\">\r\n");
      out.write("						<!-- 수정 자체가 일어나지 않을 경우를 대비해서 이렇게 파일을 미리 숨겨두는거 -->\r\n");
      out.write("							<input type=\"hidden\" name=\"oldFilename\" value=\"");
      out.print(n.getFilename());
      out.write("\">\r\n");
      out.write("							<input type=\"hidden\" name=\"oldFilepath\" value=\"");
      out.print(n.getFilepath());
      out.write("\">\r\n");
      out.write("						");
}else{ 
      out.write("\r\n");
      out.write("							<input type=\"file\" name=\"upfile\">\r\n");
      out.write("						");
} 
      out.write("\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr class=\"tr-1\">\r\n");
      out.write("					<th class=\"td-3\">내용</th>\r\n");
      out.write("						<td>\r\n");
      out.write("							<textarea class=\"input-form\" name=\"noticeContent\">");
      out.print(n.getNoticeContent());
      out.write("</textarea>\r\n");
      out.write("						</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr class=\"tr-1\">\r\n");
      out.write("					<th colspan=\"2\">\r\n");
      out.write("						<button type=\"submit\" class=\"btn bc4 bs4\">수정하기</button>\r\n");
      out.write("					</th>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script>\r\n");
      out.write("		$(\"button.delFile\").on(\"click\",function(){\r\n");
      out.write("			$(\".delFile\").hide();\r\n");
      out.write("			$(this).next().show();\r\n");
      out.write("			//nane=status인 녀석의 value를 delete로 바꿔\r\n");
      out.write("			$(\"[name=status]\").val(\"delete\");\r\n");
      out.write("		});\r\n");
      out.write("	</script>\r\n");
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
