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
 * Servlet implementation class JoinMemberServlet
 */
@WebServlet(name = "JoinMember", urlPatterns = { "/joinMember.do"})
public class JoinMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinMemberServlet() {
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
		Member m = new Member();
		m.setMemberId(request.getParameter("memberId"));
		m.setMemberPw(request.getParameter("memberPw"));
		m.setMemberName(request.getParameter("memberName"));
		m.setMemberAddr(request.getParameter("memberAddr"));
		m.setMemberPhone(request.getParameter("memberPhone"));
		
		/*
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String memberAddr = request.getParameter("memberAddr");
		String memberPhone = request.getParameter("memberPhone");
		Member m = new Member(memberId, memberPw, memberName, memberAddr, memberPhone);
		*/
		//3.비즈니스로직
		MemberService service = new MemberService();

		int result = service.joinMember(m);
		
		//4.결과처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>회원가입결과</title></head>");
		out.println("<body>");
		if(result > 0) {
			out.println("<h1>회원가입에 성공했습니다.</h1>");
		} else {
			out.println("<h1>회원가입에 실패했습니다.</h1>");
		}
		out.println("<a href='/'>메인으로 돌아가기</a>");
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
