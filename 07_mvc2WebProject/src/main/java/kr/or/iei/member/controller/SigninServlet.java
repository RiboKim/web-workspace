package kr.or.iei.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class SigninServlet
 */
@WebServlet(name = "signin", urlPatterns = { "/signin.do" })
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값추출
		String signId = request.getParameter("signId");
		String signPw = request.getParameter("signPw");
		Member m = new Member();
		m.setMemberId(signId);
		m.setMemberPw(signPw);
		//3. 비즈니스로직
		MemberService service = new MemberService();
		//입력받은 아이디/패스워드가 일치하는 회원정보를 조회
		Member member = service.selectOneMember(m);
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(member == null) {
			//아이디와 비밀번호가 틀린 경우
			request.setAttribute("title", "로그인실패");
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/");
		}else {
			//아이디 비밀번호가 일치하는 경우
			
			if(member.getMemberLevel() == 3) {
				//준회원인경우
				request.setAttribute("title","로그인 권한없음");
				request.setAttribute("msg", "로그인 권한이 없습니다. 관리자에게 문의하세요.");
				request.setAttribute("icon", "warning");
				request.setAttribute("loc","/");
			}else {
				//관리자 또는 정회원인 경우
				
				//->회원정보를 세션에 저장(서버가 회원 정보를 기억)
				//session은 브라우저 닫을 때까지 정보를 유지
				//->세션의 정보를 파기하거나, 일정시간이 지나면(30분)
				HttpSession session = request.getSession();
				session.setAttribute("m", member);
				request.setAttribute("title", "로그인성공");
				request.setAttribute("msg", "환영합니다.");
				request.setAttribute("icon", "success");
				request.setAttribute("loc", "/");
			}
			
		}
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
