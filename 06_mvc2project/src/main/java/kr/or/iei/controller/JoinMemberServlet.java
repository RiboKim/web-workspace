package kr.or.iei.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.model.service.MemberService;
import kr.or.iei.model.vo.Member;

/**
 * Servlet implementation class JoinMemberServlet
 */
@WebServlet(name = "JoinMember", urlPatterns = { "/joinMember.do" })
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
	    //3.비즈니스로직
	    MemberService service = new MemberService();
	    int result = service.joinMember(m);
	    //4.결과처리
	    //회원가입 성공시 [이름]님 환영합니다.
	    //회원가입 실패시 회원가입페이지로 이동.
	    if(result>0) {
	    	//4-1 결과를 처리할 jsp 파일을 지정
	    	RequestDispatcher view = request.getRequestDispatcher("/jsp/joinSuccess.jsp");
	    	//4-2 화면 구성에 필요한 데이터를 등록
	    	request.setAttribute("memberName", m.getMemberName());
	    	//4-3 jsp파일로 이동
	    	view.forward(request, response);
	    }else {
	    	/*
	    	//4-1. 결과처리할 페이지 지정
	    	RequestDispatcher view = request.getRequestDispatcher("/jsp/joinFrm.jsp");
	    	//4-2. 화면구현에 필요한 데이터등록(없으므로 패스)
	    	//4-3. 페이지이동
	    	view.forward(request, response);
	    	*/
	    	response.sendRedirect("/jsp.joinFrm.jsp");
	    }
	    //4-1 결과를 처리할 jsp 파일을 지정
	    /*
	    RequestDispatcher view = request.getRequestDispatcher("/jsp/join.jsp");
	    //4-2 화면 구성에 필요한 데이터를 등록
	    Integer num = result; //wrapper의 autoboxing
	    request.setAttribute("result", result);
	    //4-3 jsp파일로 이동
	    view.forward(request, response);
	    */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
