package kr.or.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.service.MemberService;
import kr.or.iei.member.vo.Member;

/**
 * Servlet implementation class AllMemberServlet
 */
@WebServlet(name = "AllMember", urlPatterns = { "/allMember.do" })
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllMemberServlet() {
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
		//->화면단에서 가져온게 없으면 생략
		//3.비즈니스로직(이 요청으로 서버가 해줘야할 일)
		//->DB에서 모든 회원을 조회
		MemberService service = new MemberService();
		ArrayList<Member> list = service.selectAllMember();
		//4.결과처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		System.out.println(list.get(0).getMemberAddr());
		
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title> 전체회원조회</title></head>");
		out.println("<body>");
		if(list.size() == 0) {
			out.println("<h2>회원정보를 조회할 수 없습니다.</h2>");
		}else {
			out.println("<h1>전체회원정보</h1>");
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
			
			for(int i=0;i<list.size();i++) {
				Member m = list.get(i);
				out.println("<tr>");
				out.println("<td>"+m.getMemberNo()+"</td>");
				//아이디는 이미 받았으니까 a태그를 통해서 찾을 수 있게 만든거
				out.println("<td><a href='/searchMember.do?memberId="+m.getMemberId()+"'>"+m.getMemberId()+"</a></td>");
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
			}
			
			out.println("</table>");
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
