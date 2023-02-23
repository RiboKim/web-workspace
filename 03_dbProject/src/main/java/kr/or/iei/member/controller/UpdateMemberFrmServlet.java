package kr.or.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.service.MemberService;
import kr.or.iei.member.vo.Member;

/**
 * Servlet implementation class UpdateMemberFrmServlet
 */
@WebServlet(name = "UpdateMemberFrm", urlPatterns = { "/updateMemberFrm.do" })
public class UpdateMemberFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberFrmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		String memberId = request.getParameter("memberId");
		//3.비즈니스로직
		MemberService service = new MemberService();
		Member m = service.selectOneMember(memberId);
		//4.결과처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title></title></head>");
		
		if(m == null) {
			out.println("<h2>회원정보를 조회할 수 없습니다.</h2>");
		} else {
			out.println("<form action='/memberUpdate.do' method='post'>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>회원번호</th>");
			out.println("<td><input type ='text' name = 'memberNo' value="+m.getMemberNo()+" readonly></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>아이디</th>");
			out.println("<td><input type ='text' name = 'memberId' value="+m.getMemberId()+" readonly></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>비밀번호</th>");
			out.println("<td><input type = 'password' name = 'memberPw' value="+m.getMemberPw()+"></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>이름</th>");
			out.println("<td><input type = 'text' name = 'memberName' value="+m.getMemberName()+" readonly></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>전화번호</th>");
			out.println("<td><input type = 'text' name = 'memberPhone' value="+m.getMemberPhone()+"></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>주소</th>");
			out.println("<td><input type = 'text' name = 'memberAddr' value="+m.getMemberAddr()+"></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>회원등급</th>");
			out.println("<td><input type = 'text' name = 'memberLevel' value="+m.getMemberLevel()+" readonly></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>가입일</th>");
			out.println("<td><input type = 'text' name = 'enrollDate' value="+m.getEnrollDate()+" readonly></td>");
			out.println("</tr></table>");
			out.println("<input type='submit' value='정보수정'>");
			out.println("</form>");
		}
		out.println("</body></html>");
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
