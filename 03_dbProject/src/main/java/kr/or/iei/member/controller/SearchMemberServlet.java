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
 * Servlet implementation class SearchMemberServlet
 */
@WebServlet(name = "SearchMember", urlPatterns = { "/searchMember.do" })
public class SearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		String memberId = request.getParameter("memberId");
		//3.비즈니스로직
		MemberService service= new MemberService();
		Member m = service.selectOneMember(memberId);
		//4.결과처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>회원정보조회</title></head>");
		
		if(m == null) {
			out.println("<h2>회원정보를 조회할 수 없습니다.</h2>");
		} else {
			out.println("<h1>회원정보</h1>");
			out.println("<hr>");
			out.println("<table border = '1'>");
			out.println("<tr>");
			out.println("<th>회원번호</th>");
			out.println("<th>아이디</th>");
			out.println("<th>비밀번호</th>");
			out.println("<th>이름</th>");
			out.println("<th>전화번호</th>");
			out.println("<th>주소</th>");
			out.println("<th>회원등급</th>");
			out.println("<th>가입일</th>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>"+m.getMemberNo()+"</td>");
			out.println("<td>"+m.getMemberId()+"</td>");
			out.println("<td>"+m.getMemberPw()+"</td>");
			out.println("<td>"+m.getMemberName()+"</td>");
			out.println("<td>"+m.getMemberPhone()+"</td>");
			out.println("<td>"+m.getMemberAddr()+"</td>");
			if(m.getMemberLevel() == 1) {
				out.println("<td>관리자</td>");
			}else if(m.getMemberLevel() == 2){
				out.println("<td>정회원</td>");
			}else {
				out.println("<td>준회원</td>");
			}
			//out.println("<td>"+m.getMemberLevel()+"</td>");
			out.println("<td>"+m.getEnrollDate()+"</td>");
			out.println("</tr>");
			
			/*ul로 쓰는 법
			 if(m == null) {
			out.println("<h2>회원정보를 조회할 수 없습니다.</h2>");
		} else {
			out.println("<h1>회원정보/h1>");
			out.println("<hr>");
			out.println("<ul>");
			out.println("<li>회원번호 : "+m.getMemberNo()+"</li>");
			out.println("<li>아이디 : "+m.getMemberId()+"</li>");
			out.println("<li>비밀번호 : "+m.getMemberPw()+"</li>");
			out.println("<li>회원이름 : "+m.getMemberName()+"</li>");
			out.println("<li>전화번호 : "+m.getMemberPhone()+"</li>");
			out.println("<li>주소 : "+m.getMemberAddr()+"</li>");
			if(m.getMemberLevel() == 1) {
				out.println("<li>관리자</li>");
			}else if(m.getMemberLevel() == 2){
				out.println("<li>정회원</li>");
			}else {
				out.println("<li>준회원</li>");
			}
			out.println("<li>가입일 : "+m.getEnrollDate()+"</li>");
			out.println("</ul>");
			
		}
			 */
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
