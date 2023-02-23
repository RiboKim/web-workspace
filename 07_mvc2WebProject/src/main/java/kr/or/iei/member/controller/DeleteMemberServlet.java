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
 * Servlet implementation class DeleteMemberServlet
 */
@WebServlet(name = "DeleteMember", urlPatterns = { "/deleteMember.do" })
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값 추출
		//회원번호 or id가 있어야 쿼리문의 where절에서 사용가능
		//세션에서 필요데이터 추출
		HttpSession session = request.getSession(false);
		Member m = (Member)session.getAttribute("m");
		String memberId = m.getMemberId();
		//3.비즈니스로직
		MemberService service = new MemberService();
		int result = service.deleteOneMember(memberId);
		//4.화면에 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "회원탈퇴성공");
			request.setAttribute("msg", "정상적으로 탈퇴되었습니다");
			request.setAttribute("icon", "success");
			request.setAttribute("loc","/logout.do");
			/*
			HttpSession session1 = request.getSession(false);
			if(session1 != null) {
				session1.invalidate();
			}
			*/
		}else {
			request.setAttribute("title", "회원탈퇴실패");
			request.setAttribute("msg", "회원탈퇴에 문제가 있습니다");
			request.setAttribute("icon", "error");
			request.setAttribute("loc","/mypage2.do");
		}
		view.forward(request, response); //이거 자체가 페이지 이동!! 이게 없으면 이동을 안한다
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
