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
 * Servlet implementation class UpdateMember2Servlet
 */
@WebServlet(name = "UpdateMember2", urlPatterns = { "/updateMember2.do" })
public class UpdateMember2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMember2Servlet() {
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
				Member member = new Member();
				member.setMemberId(request.getParameter("memberId"));
				member.setMemberPw(request.getParameter("memberPw"));
				member.setMemberPhone(request.getParameter("memberPhone"));
				member.setMemberAddr(request.getParameter("memberAddr"));
				//3.비즈니스로직
				MemberService service = new MemberService();
				int result = service.updateMember(member);
				//4.결과처리
				//->다시 마이페이지를 바로 띄우는 방법
				/*
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/mypage1.jsp");
				view.forward(request, response);
				*/
				//->msg.jsp이용해서 alert를 띄운후 마이페이지로 가는 방법
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
				if(result>0) {
					request.setAttribute("title", "정보변경성공");
					request.setAttribute("msg", "정보가 수정되었습니다.");
					request.setAttribute("icon", "success");
				}else {
					request.setAttribute("title", "정보변경실패");
					request.setAttribute("msg", "정보변경해 실패했습니다.");
					request.setAttribute("icon", "error");
				}
				//WEB-INF는 바로 들어갈 수가 없음 무조건 RequestDispatcher로 불러가야함
				//아이디를 보내지를 않으니 null값이 나와서 오류가 난다. 그러니까 mypage2.do로 갈때 이렇게 아이디를 넣어주는거
				request.setAttribute("loc","/mypage2.do?memberId="+member.getMemberId());
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
