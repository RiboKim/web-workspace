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
 * Servlet implementation class UpdateMember1Servlet
 */
@WebServlet(name = "UpdateMember1", urlPatterns = { "/updateMember1.do" })
public class UpdateMember1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMember1Servlet() {
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
			HttpSession session = request.getSession();
			Member m = (Member)session.getAttribute("m"); //세션은 항상 ojbect, 그러니까 형변환 하자
			//m은 로그인할때의 이전 데이터, member는 새로 수정한 데이터
			m.setMemberPw(member.getMemberPw());
			m.setMemberPhone(member.getMemberPhone());
			m.setMemberAddr(member.getMemberAddr());
			request.setAttribute("title", "정보변경성공");
			request.setAttribute("msg", "정보가 수정되었습니다.");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "정보변경실패");
			request.setAttribute("msg", "정보변경해 실패했습니다.");
			request.setAttribute("icon", "error");
		}
		//WEB-INF는 바로 들어갈 수가 없음 무조건 RequestDispatcher로 불러가야함
		//근데 지금 상황에서는 어차피 servlet을 거쳐서 가야하니까 그냥 처음부터 /mypage1.do 가면 된다
		request.setAttribute("loc","/mypage1.do");
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
